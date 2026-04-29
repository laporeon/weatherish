package com.laporeon.weatherish.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.laporeon.weatherish.enums.Color;
import com.laporeon.weatherish.models.Weather;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String ERROR_MESSAGE = "❌ Error %s: %s. Please check your input and try again.";

    private final Gson gson;
    private final HttpClient httpClient;
    private final String apiKey;

    public WeatherClient(Gson gson, HttpClient httpClient) {
        this.gson = gson;
        this.httpClient = httpClient;
        this.apiKey = resolveApiKey();
    }

    public Weather getData(String city, String unit) throws Exception {
        // Only spaces need to be encoded as %20 to produce a valid URL
        // as OpenWeatherMap API handles city name with accents.
        String formattedCity = city.replace(" ", "%20");

        String url = BASE_URL + "/weather?q=" + formattedCity + "&appid=" + apiKey + "&units=" + unit;

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

    private static String resolveApiKey() {
        String key = System.getenv("API_KEY");
        if (key == null || key.isBlank()) {
            System.err.printf("%s❌ Error: API_KEY variable is not set.%s", Color.RED, Color.RESET);
            System.exit(1);
        }
        return key;
    }

}
