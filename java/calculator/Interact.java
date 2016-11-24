package calculator;

import java.util.Scanner;

public class Interact {

	public static void main(String[] args) {
		String answer = "", exit = "e", calculator = "c";
		Scanner input = new Scanner(System.in);
		CalcMenu menu = new CalcMenu();

		do {
			menu.greet();
			menu.mainMenu();
			answer = input.nextLine();
			if (answer.equals(calculator)) {
				menu.calcMenu();
			}
		} while (!answer.equals(exit));
		
		System.out.println("Exiting program...");
		System.out.println("exited :)");
	}
}
