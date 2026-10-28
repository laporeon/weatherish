package com.laporeon.weatherish.helpers;

import com.laporeon.weatherish.enums.Unit;
import com.laporeon.weatherish.models.Weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Formatter {
    public static String formatOutput(Weather data, Unit unit) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM, HH:mm");

        String name = data.name();
        String temperature = formatTemperature(data.main().temp(), unit);
        String feelsLike = formatTemperature(data.main().feelsLike(), unit);
        String wind = formatWindSpeed(data.wind().speed(), unit);
        String humidity = String.format("%.0f%%", data.main().humidity());
        String date = LocalDateTime.now().format(dateTimeFormatter);

        return """
                    📌 City: %s
                    🕓 Date: %s
                    🌞 Temperature: %s
                    🔥 Feels like: %s
                    💨 Wind: %s
                    💦 Humidity: %s
                """.formatted(name, date, temperature, feelsLike, wind, humidity);
    }

    private static String formatWindSpeed(double speed, Unit unit) {
        if (unit == Unit.IMPERIAL) {
            return String.format("%.0f %s", speed, unit.getWindSpeedUnit());
        }

        return String.format("%.0f %s", speed * 3.6, unit.getWindSpeedUnit());
    }

    private static String formatTemperature(double temperature, Unit unit) {
        return String.format("%.0f%s", temperature, unit.getTemperatureUnit());
    }
}
