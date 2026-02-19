package com.laporeon.weatherish.helpers;

import com.laporeon.weatherish.enums.Unit;
import com.laporeon.weatherish.models.Weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public static String formatWindSpeed(double speed, String unit) {
        Unit unitEnum = Unit.fromString(unit);

        if (unitEnum == Unit.IMPERIAL) {
            return String.format("%.0f %s", speed, unitEnum.getWindSpeedUnit());
        }

        return String.format("%.0f %s", speed * 3.6, unitEnum.getWindSpeedUnit());
    }

    public static String formatTemperature(double temperature, String unit) {
        return String.format("%.0f%s", temperature, Unit.fromString(unit).getTemperatureUnit());
    }

    public static String formatOutput(Weather data, String unit) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, HH:mm");

        String name = data.name;
        String temperature = Formatter.formatTemperature(data.main.temp, unit);
        String feelsLike = Formatter.formatTemperature(data.main.feelsLike, unit);
        String wind = Formatter.formatWindSpeed(data.wind.speed, unit);
        String humidity = String.format("%.0f%%", data.main.humidity);

        return """
                    📌 City: %s
                    🕓 Local Time: %s
                    ⛅ Temperature: %s
                    🔥 Feels like: %s
                    💨 Wind: %s
                    💦 Humidity: %s
                """.formatted(name, LocalDateTime.now().format(dateTimeFormatter), temperature, feelsLike, wind, humidity);
    }
}
