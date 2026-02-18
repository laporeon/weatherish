package com.laporeon.weatherish;

import com.laporeon.weatherish.client.WeatherClient;
import com.laporeon.weatherish.helpers.Formatter;
import com.laporeon.weatherish.models.Weather;

import java.util.Scanner;

public class Weatherish {

	public static void main(String[] args) throws Exception {
		clearScreen();

		Scanner scanner = new Scanner(System.in);

		System.out.println("""
				 __        __         _   _               _     _    \s
				 \\ \\      / /__  __ _| |_| |__   ___ _ __(_)___| |__ \s
				  \\ \\ /\\ / / _ \\/ _` | __| '_ \\ / _ \\ '__| / __| '_ \\\s
				   \\ V  V /  __/ (_| | |_| | | |  __/ |  | \\__ \\ | | |
				    \\_/\\_/ \\___|\\__,_|\\__|_| |_|\\___|_|  |_|___/_| |_|
				   \s""");

		System.out.print("Enter city name: ");
		String city = scanner.nextLine().trim();

		System.out.print("Choose what measurement unit you want to use (e.g. metric, imperial): ");
		String unit = scanner.nextLine().trim();

		Weather response = new WeatherClient().getData(city, unit);
		String formattedResponse = Formatter.formatOutput(response, unit);

		scanner.close();

		System.out.printf("\n%s\n", formattedResponse);

	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
