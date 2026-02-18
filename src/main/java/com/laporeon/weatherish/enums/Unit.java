package com.laporeon.weatherish.enums;

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

    public String getLocalTimeFormat() { return localTimeFormat; }
    public String getTemperatureUnit() { return temperatureUnit; }
    public String getWindSpeedUnit() { return windSpeedUnit; }

}
