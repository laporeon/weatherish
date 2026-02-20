package com.laporeon.weatherish.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.laporeon.weatherish.models.Weather;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String API_KEY = Dotenv.load().get("API_KEY");
    private static final String ERROR_MESSAGE = "❌ Error %s: %s. Please check your input and try again.";

    public Weather getData(String city, String unit) throws Exception {
        String url = BASE_URL + "/weather?q=" + city + "&appid=" + API_KEY + "&units=" + unit;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .GET()
                                         .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            JsonObject error = new Gson().fromJson(response.body(), JsonObject.class);
            String status = error.get("cod").getAsString();
            String message =  error.get("message").getAsString();
            throw new RuntimeException(ERROR_MESSAGE.formatted(status, message));
        }

        return new Gson().fromJson(response.body(), Weather.class);
    }

}
