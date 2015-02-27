/*
 * Copyright (C) 2012-2015 Radical Electronic Systems, South Africa
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.radicales.sm100.protocol;

/**
 * XML For Smart Mist Set Zone Message
 *
 * @author
 * Jan Zwiegers,
 * <a href="mailto:jan@radicalsystems.co.za">jan@radicalsystems.co.za</a>,
 * <a href="http://www.radicalsystems.co.za">www.radicalsystems.co.za</a>
 *
 * @version
 * <b>1.0 01/11/2014</b><br>
 * Original release.
 */
public class X4smSetZoneMessage extends X4smMessage {

    private int gChannel;
    private int gStatus;

    public X4smSetZoneMessage( int Channel, int Status ) {
        super(X4smMessage.MSG_TYPE_SET_ZONE);
        gChannel = Channel;
        gStatus = Status;
        encode();
    }

    private String statusToString() {
        if(gStatus == 1) {
            return "ON";
        }
        else if(gStatus == 2) {
            return "TOGGLE";
        }

        return "OFF";
    }

    private void encode() {
        String msg = "<ControlZone channel=\"";
        msg = msg + Integer.toString(gChannel) + "\" value=\"";
        msg = msg + statusToString() + "\" />";
        setData(msg);
    }

}
