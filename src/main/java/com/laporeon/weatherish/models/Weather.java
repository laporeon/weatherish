package com.laporeon.weatherish.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Weather {

    public String name;
    public Main main;
    public Wind wind;

    public static class Main {
        public double temp;

        @SerializedName("feels_like")
        public double feelsLike;

        public double humidity;
    }

    public static class Wind {
        public double speed;
    }

}
