package com.laporeon.weatherish;

import com.google.gson.Gson;
import com.laporeon.weatherish.application.CommandLineInterface;
import com.laporeon.weatherish.client.WeatherClient;
import com.laporeon.weatherish.helpers.Formatter;

import java.net.http.HttpClient;
import java.util.Scanner;

public class Weatherish {

	public static void main(String[] args)  {

		WeatherClient client = new WeatherClient(new Gson(), HttpClient.newHttpClient());
		CommandLineInterface commandLineInterface = new CommandLineInterface(new Scanner(System.in), new Formatter(), client);
		commandLineInterface.start();
		
	}

}
