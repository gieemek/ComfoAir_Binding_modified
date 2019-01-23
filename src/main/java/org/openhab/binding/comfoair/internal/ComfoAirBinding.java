/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.comfoair.internal;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.openhab.binding.comfoair.ComfoAirBindingProvider;
import org.openhab.binding.comfoair.datatypes.ComfoAirDataType;
import org.openhab.binding.comfoair.handling.ComfoAirCommand;
import org.openhab.binding.comfoair.handling.ComfoAirCommandType;
import org.openhab.binding.comfoair.handling.ComfoAirConnector;
import org.openhab.core.binding.AbstractActiveBinding;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.types.Command;
import org.openhab.core.types.State;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An active binding which requests a given URL frequently.
 *
 * @author Holger Hees
 * @since 1.3.0
 */
public class ComfoAirBinding extends AbstractActiveBinding<ComfoAirBindingProvider> implements ManagedService {

    static final Logger logger = LoggerFactory.getLogger(ComfoAirBinding.class);

    /**
     * The interval to find new refresh candidates (defaults to 60000
     * milliseconds).
     */
    private long refreshInterval = 60000L;
    private String port;

    private ComfoAirConnector connector;

    private ScheduledExecutorService scheduler;

    /**
     * @{inheritDoc
     */
    @Override
    public void activate() {
        scheduler = Executors.newScheduledThreadPool(10);
    }

    /**
     * @{inheritDoc
     */
    @Override
    public void deactivate() {
        for (ComfoAirBindingProvider provider : providers) {
            provider.removeBindingChangeListener(this);
        }

        if (scheduler != null) {
            scheduler.shutdown();
            try {
                scheduler.awaitTermination(5000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.warn("Unable to shutdown scheduler!");
            }
        }

        providers.clear();

        if (connector != null) {
            connector.close();
        }
    }

    /**
     * @{inheritDoc
     */
    @Override
    protected long getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * @{inheritDoc
     */
    @Override
    protected String getName() {
        return "ComfoAir Refresh Service";
    }

    /**
     * @{inheritDoc
     */
    @Override
    public void internalReceiveCommand(String itemName, Command command) {
        Set<String> usedKeys = new HashSet<String>();

        for (ComfoAirBindingProvider provider : providers) {
            usedKeys.addAll(provider.getConfiguredKeys());
        }

        for (ComfoAirBindingProvider provider : providers) {
            String eventType = provider.getConfiguredKeyForItem(itemName);
            ComfoAirCommand changeCommand = ComfoAirCommandType.getChangeCommand(eventType, (DecimalType) command);

            sendCommand(changeCommand);

            Collection<ComfoAirCommand> affectedReadCommands = ComfoAirCommandType.getAffectedReadCommands(eventType,
                    usedKeys);

            if (affectedReadCommands.size() > 0) {
                // refresh 3 seconds later all affected items
                Runnable updateThread = new AffectedItemsUpdateThread(affectedReadCommands);
                scheduler.schedule(updateThread, 3, TimeUnit.SECONDS);
            }
        }
    }

    /**
     * @{inheritDoc
     */
    @Override
    public void execute() {
        for (ComfoAirBindingProvider provider : providers) {
            Collection<ComfoAirCommand> commands = ComfoAirCommandType
                    .getReadCommandsByEventTypes(provider.getConfiguredKeys());

            for (ComfoAirCommand command : commands) {
                sendCommand(command);
            }
        }
    }

    /**
     * send a command and send additional command which are affected by the
     * first command
     *
     * @param command
     * @return int[] values
     */
    private int[] sendCommand(ComfoAirCommand command) {
        Integer requestCmd = command.getRequestCmd();
        Integer replyCmd = command.getReplyCmd();
        int[] requestData = command.getRequestData();

        Integer preRequestCmd;
        Integer preReplyCmd;
        int[] preResponse = null;

        switch (requestCmd) {
            case 0x9f:
                preRequestCmd = 0x9d;
                preReplyCmd = 0x9e;
                break;
            case 0xcb:
                preRequestCmd = 0xc9;
                preReplyCmd = 0xca;
                break;
            case 0xcf:
                preRequestCmd = 0xcd;
                preReplyCmd = 0xce;
                break;
            case 0xd7:
                preRequestCmd = 0xd5;
                preReplyCmd = 0xd6;
                break;
            case 0xed:
                preRequestCmd = 0xeb;
                preReplyCmd = 0xec;
                break;
            default:
                preRequestCmd = requestCmd;
                preReplyCmd = replyCmd;
        }

        if (preRequestCmd != requestCmd) {
            command.setRequestCmd(preRequestCmd);
            command.setReplyCmd(preReplyCmd);
            command.setRequestData(null);

            preResponse = connector.sendCommand(command, null);

            if (preResponse == null) {
                return null;
            } else {
                command.setRequestCmd(requestCmd);
                command.setReplyCmd(replyCmd);
                command.setRequestData(requestData);
            }
        }

        int[] response = connector.sendCommand(command, preResponse);

        if (response == null) {
            return null;
        }

        List<ComfoAirCommandType> commandTypes = ComfoAirCommandType.getCommandTypesByReplyCmd(command.getReplyCmd());

        for (ComfoAirCommandType commandType : commandTypes) {
            ComfoAirDataType dataType = commandType.getDataType();
            State value = dataType.convertToState(response, commandType);

            if (value == null) {
                logger.warn("Unexpected value for DATA: {}", ComfoAirConnector.dumpData(response));
            } else {
                for (ComfoAirBindingProvider provider : providers) {
                    List<String> items = provider.getItemNamesForCommandKey(commandType.getKey());
                    for (String item : items) {
                        eventPublisher.postUpdate(item, value);
                    }
                }
            }
        }

        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("rawtypes")
    public void updated(Dictionary config) throws ConfigurationException {

        if (config != null) {
            String newPort = (String) config.get("port"); //$NON-NLS-1$
            if (StringUtils.isNotBlank(newPort) && !newPort.equals(port)) {
                // only do something if the newPort has changed
                port = newPort;

                String refreshIntervalString = (String) config.get("refresh");
                if (StringUtils.isNotBlank(refreshIntervalString)) {
                    refreshInterval = Long.parseLong(refreshIntervalString);
                }

                if (connector != null) {
                    connector.close();
                }

                connector = new ComfoAirConnector();
                try {
                    connector.open(port);
                } catch (InitializationException e) {
                    logger.error(e.getMessage());
                }

                setProperlyConfigured(true);
            }
        }
    }

    protected void addBindingProvider(ComfoAirBindingProvider bindingProvider) {
        super.addBindingProvider(bindingProvider);
    }

    protected void removeBindingProvider(ComfoAirBindingProvider bindingProvider) {
        super.removeBindingProvider(bindingProvider);
    }

    private class AffectedItemsUpdateThread extends Thread {

        private Collection<ComfoAirCommand> affectedReadCommands;

        public AffectedItemsUpdateThread(Collection<ComfoAirCommand> affectedReadCommands) {
            this.affectedReadCommands = affectedReadCommands;
        }

        @Override
        public void run() {
            for (ComfoAirCommand readCommand : this.affectedReadCommands) {
                sendCommand(readCommand);
            }
        }
    }

}