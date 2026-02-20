package com.laporeon.weatherish.application;

import com.laporeon.weatherish.client.WeatherClient;
import com.laporeon.weatherish.enums.Color;
import com.laporeon.weatherish.enums.Unit;
import com.laporeon.weatherish.helpers.Formatter;
import com.laporeon.weatherish.models.Weather;

import java.util.Scanner;

public class CommandLineInterface {

    Scanner scanner = new Scanner(System.in);
    Formatter formatter = new Formatter();

    public void start() {
        displayLogo();

        String city = promptCity();
        String unit = promptUnit();

        scanner.close();

        try {
            Weather data = new WeatherClient().getData(city, unit);
            String formattedResponse = formatter.formatOutput(data, unit);

            System.out.printf("\n%s\n", formattedResponse);
        } catch (Exception ex) {
            System.out.printf("\n%s%s%s\n", Color.RED, ex.getMessage(), Color.RESET);
        }

        System.exit(0);
    }

    private String promptCity() {
        System.out.printf("%sEnter city name: %s", Color.BOLD, Color.RESET);
        String city = scanner.nextLine().trim();

        while (city.isEmpty()) {
            System.out.printf("%s%sCity name cannot be empty. Try again...%s\n", Color.ITALIC, Color.RED, Color.RESET);
            System.out.printf("%sEnter city name: %s", Color.BOLD, Color.RESET);
            city = scanner.nextLine().trim();
        }

        return city;
    }

    private String promptUnit() {
        System.out.printf("""
        %sChoose a measurement unit:
        [1] Metric (°C, km/h)
        [2] Imperial (°F, mph)%s
        """, Color.BOLD, Color.RESET);
        System.out.printf("%sEnter your choice: %s", Color.BOLD, Color.RESET);
        String input = scanner.nextLine().trim();

        while (!input.equals("1") && !input.equals("2")) {
            System.out.printf("%s%sInvalid option. Try again...%s\n", Color.ITALIC, Color.RED, Color.RESET);
            System.out.printf("%sEnter your choice: %s", Color.BOLD, Color.RESET);
            input = scanner.nextLine().trim();
        }

        int value = Integer.parseInt(input);
        return Unit.values()[value - 1].name();
    }

    private void displayLogo() {
        clearScreen();

        System.out.printf("%s" + """
        
         __        __         _   _               _     _
         \\ \\      / /__  __ _| |_| |__   ___ _ __(_)___| |__
          \\ \\ /\\ / / _ \\/ _` | __| '_ \\ / _ \\ '__| / __| '_ \\
           \\ V  V /  __/ (_| | |_| | | |  __/ |  | \\__ \\ | | |
            \\_/\\_/ \\___|\\__,_|\\__|_| |_|\\___|_|  |_|___/_| |_|
        """ + "%s%n", Color.GREEN, Color.RESET);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
