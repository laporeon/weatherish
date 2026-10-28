package com.laporeon.weatherish;

import com.google.gson.Gson;
import com.laporeon.weatherish.application.CommandLineInterface;
import com.laporeon.weatherish.client.WeatherClient;
import com.laporeon.weatherish.config.EnvironmentConfiguration;

import java.net.http.HttpClient;

public class Weatherish {
	public static void main(String[] args)  {
		EnvironmentConfiguration.validate();
		WeatherClient client = new WeatherClient(new Gson(), HttpClient.newHttpClient(), EnvironmentConfiguration.apiKey());
		new CommandLineInterface(client).start();
	}
}
