package com.laporeon.weatherish.helpers;

import com.laporeon.weatherish.enums.Unit;
import com.laporeon.weatherish.models.Weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public String formatOutput(Weather data, String unit) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM, HH:mm");

        String name = data.name;
        String temperature = formatTemperature(data.main.temp, unit);
        String feelsLike = formatTemperature(data.main.feelsLike, unit);
        String wind = formatWindSpeed(data.wind.speed, unit);
        String humidity = String.format("%.0f%%", data.main.humidity);

        return """
                    📌 City: %s
                    🕓 Date: %s
                    🌞 Temperature: %s
                    🔥 Feels like: %s
                    💨 Wind: %s
                    💦 Humidity: %s
                """.formatted(name, LocalDateTime.now().format(dateTimeFormatter), temperature, feelsLike, wind, humidity);
    }

    private String formatWindSpeed(double speed, String unit) {
        Unit unitEnum = Unit.fromString(unit);

        if (unitEnum == Unit.IMPERIAL) {
            return String.format("%.0f %s", speed, unitEnum.getWindSpeedUnit());
        }

        return String.format("%.0f %s", speed * 3.6, unitEnum.getWindSpeedUnit());
    }

    private String formatTemperature(double temperature, String unit) {
        return String.format("%.0f%s", temperature, Unit.fromString(unit).getTemperatureUnit());
    }

}
