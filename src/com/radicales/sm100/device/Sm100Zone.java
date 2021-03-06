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
package com.radicales.sm100.device;

/**
 * Smart Mist 100 Watering Zone
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
public class Sm100Zone {

    private static final long CW_NONE = 0x00000000;
    private static final long CW_ENABLED = 0x00000001;
    private static final long CW_PUMP = 0x00000002;
    private static final long CW_WIND = 0x00000004;
    private static final long CW_TEMP = 0x00000008;

    private String gName;
    private int gIndex;
    private long gControlWord;
    private int gInitValue;
    private int gOffDelay;
    private boolean gStatus;

    /**
     * Creates new form Smart Mist 100 Zone Object
     * @param Name Name of zones
     */
    public Sm100Zone( String Name ) {
        gName = Name;
        gIndex = -1;
        gControlWord = 0;
        gInitValue = 0;
        gOffDelay = 0;
        gStatus = false;
    }

    /**
     * Creates new form Smart Mist 100 Zone Object
     * @param Name Name of zones
     * @param Channel Channel index of device
     * @param ControlWord Settings word for this zone
     * @param InitValue Startup state
     * @param OffDelay Zone/Channel off delay
     * @param Enabled Zone is enabled
     */
    public Sm100Zone( String Name, int Channel, long ControlWord, boolean InitValue, int OffDelay, boolean Enabled ) {
        gName = Name;
        gIndex = -1;
        gControlWord = 0;
        gInitValue = 0;
        gOffDelay = 0;
        gStatus = false;
        gStatus = Enabled;
    }

    public int getIndex() {
        return gIndex;
    }

    public int getInitValue() {
        return gInitValue;
    }

    public String getName() {
        return gName;
    }

    public boolean getStatus() {
        return gStatus;
    }

    public boolean isOn() {
        return gStatus;
    }

    public void setStatus(boolean Value) {
        this.gStatus = Value;
    }

    public int getOffDelay() {
        return gOffDelay;
    }

    public void setControlWord( long Value ) {
        this.gControlWord = Value;
    }

    public void setChannel( int Value ) {
        this.gIndex = Value;
    }

    public int getChannel() {
        return this.gIndex;
    }

    public void setInitValue( int Value ) {
        this.gInitValue = Value;
    }

    public boolean isInitValue() {
        if(this.gInitValue > 0) {
            return true;
        }

        return false;
    }

    public void setOffDelay( int Value ) {
        this.gOffDelay = Value;
    }

    public long getControlWord() {
        return gControlWord;
    }

    public boolean getInitState() {
        if(gInitValue > 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return gName;
    }

}
