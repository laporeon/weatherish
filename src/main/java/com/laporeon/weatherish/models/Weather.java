package com.laporeon.weatherish.models;

import com.google.gson.annotations.SerializedName;

public record Weather(
        String name,
        Main main,
        Wind wind
) {

    public record Main(
            double temp,
            @SerializedName("feels_like")
            double feelsLike,
            double humidity
    ) {}

    public record Wind(double speed) {}
}