package com.laporeon.weatherish.enums;

import lombok.Getter;

@Getter
public enum Unit {

    METRIC("pt-BR", "°C", "km/h"),
    IMPERIAL("en-US", "°F", "mph");

    private final String localTimeFormat;
    private final String temperatureUnit;
    private final String windSpeedUnit;

    Unit(String localTimeFormat, String temperatureUnit, String windSpeedUnit) {
        this.localTimeFormat = localTimeFormat;
        this.temperatureUnit = temperatureUnit;
        this.windSpeedUnit = windSpeedUnit;
    }

    public static Unit fromString(String unit) {
        return valueOf(unit.toUpperCase());
    }
}
