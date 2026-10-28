package com.laporeon.weatherish.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.laporeon.weatherish.enums.Unit;
import com.laporeon.weatherish.models.Weather;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherClient {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String ERROR_MESSAGE = "❌ Error %s: %s. Please check your input and try again.";

    private final Gson gson;
    private final HttpClient httpClient;
    private final String apiKey;

    public WeatherClient(Gson gson, HttpClient httpClient, String apiKey) {
        this.gson = gson;
        this.httpClient = httpClient;
        this.apiKey = apiKey;
    }

    public Weather getData(String city, Unit unit) throws Exception {
        String encodedCity = URLEncoder.encode(city + ",BR", StandardCharsets.UTF_8)
                                       .replace("+", "%20");

        String url = "%s/weather?q=%s&appid=%s&units=%s".formatted(
                BASE_URL,
                encodedCity,
                URLEncoder.encode(apiKey, StandardCharsets.UTF_8),
                unit.getValue()
        );

        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .GET()
                                         .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            JsonObject error = gson.fromJson(response.body(), JsonObject.class);
            String status = error.get("cod").getAsString();
            String message =  error.get("message").getAsString();
            throw new RuntimeException(ERROR_MESSAGE.formatted(status, message));
        }

        return gson.fromJson(response.body(), Weather.class);
    }
}
