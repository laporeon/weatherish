package com.laporeon.weatherish.client;

import com.google.gson.Gson;
import com.laporeon.weatherish.models.Weather;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String API_KEY = Dotenv.load().get("API_KEY");

    public Weather getData(String city, String unit) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(BASE_URL + "/weather?q=" + city + "&appid=" + API_KEY +
                                                 "&units=" + unit))
                                         .GET()
                                         .build();

        String body = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        return new Gson().fromJson(body, Weather.class);
    }

}
