package com.laporeon.weatherish.enums;

public enum Unit {

    METRIC("°C", "km/h"),
    IMPERIAL("°F", "mph");

    private final String temperatureUnit;
    private final String windSpeedUnit;

    Unit(String temperatureUnit, String windSpeedUnit) {
        this.temperatureUnit = temperatureUnit;
        this.windSpeedUnit = windSpeedUnit;
    }
    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public static Unit fromString(String unit) {
        return valueOf(unit.toUpperCase());
    }
}
