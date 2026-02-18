package com.laporeon.weatherish.helpers;

import com.laporeon.weatherish.enums.Unit;

public class Formatter {

    public String formatWindSpeed(String units, double speed, String speedUnit) {
        if (units.equals(Unit.IMPERIAL.name())) {
            return String.format("%.0f %s", speed, speedUnit);
        }

        return String.format("%.0f %s", speed * 3.6, speedUnit);
    }

    public String formatTemperature(double temperature,String tempUnit) {
        return String.format("%.0f %s", temperature, tempUnit);
    }
}
