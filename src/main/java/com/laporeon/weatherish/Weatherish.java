package com.laporeon.weatherish;

import java.util.Scanner;

public class Weatherish {

	public static void main(String[] args) {
		clearScreen();

		Scanner scanner = new Scanner(System.in);

		System.out.println("""
				 __        __         _   _               _     _    \s
				 \\ \\      / /__  __ _| |_| |__   ___ _ __(_)___| |__ \s
				  \\ \\ /\\ / / _ \\/ _` | __| '_ \\ / _ \\ '__| / __| '_ \\\s
				   \\ V  V /  __/ (_| | |_| | | |  __/ |  | \\__ \\ | | |
				    \\_/\\_/ \\___|\\__,_|\\__|_| |_|\\___|_|  |_|___/_| |_|
				   \s""");

		System.out.print("Press enter to exit: ");
		scanner.nextLine();

		clearScreen();
		scanner.close();
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
