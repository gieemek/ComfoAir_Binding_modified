/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.comfoair.datatypes;

import org.openhab.binding.comfoair.handling.ComfoAirCommandType;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.types.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to handle volt values
 *
 * @author Grzegorz Miasko
 * @since 1.14.0
 */
public class DataTypeVolt implements ComfoAirDataType {

    private static final Logger logger = LoggerFactory.getLogger(DataTypeVolt.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public State convertToState(int[] data, ComfoAirCommandType commandType) {

        if (data == null || commandType == null) {
            logger.error("Error of \"DataTypeVolt\" class \"convertToState\" method parameter: null");
            return null;
        } else {

            if (commandType.getGetReplyDataPos()[0] < data.length) {
                return new DecimalType((double) data[commandType.getGetReplyDataPos()[0]] * 10 / 255);
            } else {
                return null;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] convertFromState(State value, ComfoAirCommandType commandType) {

        if (value == null || commandType == null) {
            logger.error("Error of \"DataTypeVolt\" class \"convertFromState\" method parameter: null");
            return null;
        } else {

            int[] template = commandType.getChangeDataTemplate();

            template[commandType.getChangeDataPos()] = (int) (((DecimalType) value).doubleValue() * 255 / 10);

            return template;
        }
    }

}
