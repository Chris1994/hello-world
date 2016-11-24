package calculator;

import java.io.IOException;
import java.util.Scanner;

class Interaction {

	public static void main(String[] args) throws IOException {
		String answer = "", exit = "e", calculator = "c", people = "p";
		Scanner in = new Scanner(System.in);
		AppMenu menu = new AppMenu();

		try {
			do {
				menu.greet();
				menu.mainMenu();
				answer = in.nextLine();
				if (answer.equals(calculator)) {
					menu.calcMenu();
				} else if (answer.equals(people)) {
					menu.dataQueries();
				} else if (answer.equals(exit)) {
					return;
				}
				else {
					System.err.println("Invalid selection :(");
				}

			} while (!answer.equals(exit));

		} finally {
			in.close();
			System.out.println("Exiting program...");
			System.out.println("exited :)");
		}
	}
}
