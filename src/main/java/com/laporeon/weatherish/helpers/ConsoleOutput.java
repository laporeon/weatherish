package com.laporeon.weatherish.helpers;

public class ConsoleOutput {

    public void outputWeatherData() {
        System.out.println("""
                📌 City: %s
                🕓 Local Time: %s
                ⛅ Temperature: %s
                🔥 Feels like: %s
                💨 Wind: %s
                💦 Humidity: %s%
                """);
    }

}
