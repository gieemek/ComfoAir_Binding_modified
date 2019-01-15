/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
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

/**
 * Class to handle numeric values
 *
 * @author Holger Hees
 * @since 1.3.0
 * @author Grzegorz Miasko
 * @since 1.14.0
 */
public class DataTypeNumber implements ComfoAirDataType {

    /**
     * {@inheritDoc}
     */
    @Override
    public State convertToState(int[] data, ComfoAirCommandType commandType) {

        int[] get_reply_data_pos = commandType.getGetReplyDataPos();

        int value = 0;
        int base = 0;

        for (int i = get_reply_data_pos.length - 1; i >= 0; i--) {
            value += data[get_reply_data_pos[i]] << base;
            base += 8;
        }

        int[] possibleValues = commandType.getPossibleValues();
        if (possibleValues != null) {

            // fix for unexpected value for "level" value. got a 0x33. valid was
            // the 0x03. 0x30 was to much.
            // send DATA: 07 f0 00 cd 00 7a 07 0f
            // receive CMD: ce DATA: 0f 20 32 00 0f 21 33 2d 33 03 01 5a 5b 00
            for (int possibleValue : possibleValues) {
                if ((value & possibleValue) == possibleValue) {
                    return new DecimalType(value);
                }
            }

            return null;
        }

        return new DecimalType(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] convertFromState(State value, ComfoAirCommandType commandType) {

        int[] template = commandType.getChangeDataTemplate();
        int[] possibleValues = commandType.getPossibleValues();

        int intValue = ((DecimalType) value).intValue();

        // by GM dopisany warunek dla przypadku braku podania possibleValues
        /*
         * for (int i = 0; i < possibleValues.length; i++) {
         * if (possibleValues[i] == intValue) {
         * template[commandType.getChangeDataPos()] = intValue;
         * break;
         * }
         * }
         */
        if (possibleValues == null) {
            template[commandType.getChangeDataPos()] = intValue;
        } else {
            for (int i = 0; i < possibleValues.length; i++) {
                if (possibleValues[i] == intValue) {
                    template[commandType.getChangeDataPos()] = intValue;
                    break;
                }
            }
        }

        System.out.println(template);

        return template;
    }

}
