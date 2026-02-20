package com.laporeon.weatherish.enums;

import lombok.Getter;

@Getter
public enum Unit {

    METRIC("°C", "km/h"),
    IMPERIAL("°F", "mph");

    private final String temperatureUnit;
    private final String windSpeedUnit;

    Unit(String temperatureUnit, String windSpeedUnit) {
        this.temperatureUnit = temperatureUnit;
        this.windSpeedUnit = windSpeedUnit;
    }

    public static Unit fromString(String unit) {
        return valueOf(unit.toUpperCase());
    }
}
