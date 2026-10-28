package com.laporeon.weatherish.enums;

public enum Unit {
    METRIC("metric", "°C", "km/h"),
    IMPERIAL("imperial", "°F", "mph");

    private final String value;
    private final String temperatureUnit;
    private final String windSpeedUnit;

    Unit(String value, String temperatureUnit, String windSpeedUnit) {
        this.value = value;
        this.temperatureUnit = temperatureUnit;
        this.windSpeedUnit = windSpeedUnit;
    }

    public String getValue() {
        return value;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public static Unit fromOption(String input) {
        return switch (input) {
            case "1" -> METRIC;
            case "2" -> IMPERIAL;
            default -> throw new IllegalArgumentException(
                    "Invalid unit option: " + input
            );
        };
    }
}
