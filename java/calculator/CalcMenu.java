package calculator;
import java.util.ArrayList;
import java.util.Scanner;

class CalcMenu {
	ArrayList<String> ops = new ArrayList<>();
	Calculator calc = new Calculator();
	Scanner in = new Scanner(System.in);
	String back = "b", evaluate = "e", ans, operation = " ";
	private double first_num, second_num, result = 0.0, temp;

	protected CalcMenu() {
		ops.add("+");
		ops.add("-");
		ops.add("*");
		ops.add("/");
		this.first_num = 0.0;
		this.second_num = 0.0;
		this.result = 0.0;
		this.temp = 0.0;
	}
	
	protected void greet() {
		System.out.print("\n   |---------------------------------------------|");
		System.out.println("\n   |   v1.0.1 - Created by Christopher Truebig   |");
		System.out.println("   |                                             |");
		System.out.println("   |        This program does mathematical       |");
		System.out.println("   | 	        computations and file IO         |");
		System.out.println("   |______--------------------------------_______|\n");
	}
	protected void mainMenu() {
		System.out.println("\t\t [(c)alculator   ]\n\t\t [(e)xit program ]");
	}
	protected void calcMenu() {
		do {			
			System.out.println("\t\t [(e)valuate      ]");
			System.out.println("\t\t [(r)eturn        ]");
			ans = in.nextLine();
			if (ans.equals(evaluate)) {
				System.out.print("num1: ");
				first_num = in.nextDouble();
				
				System.out.print("operation: ( + - * / ): ");
				operation = in.next();
				if(!ops.contains(operation)) {
					System.out.println("Invalid Input :(");
					in.nextLine();		// clear the buffer
					continue;
				}
				
				System.out.print("num2: ");
				second_num = in.nextDouble();
				
				in.nextLine();
				
				result = calc.eval(operation, result, first_num, second_num);
				System.out.println(first_num  + " " + operation + " " + second_num + " = " + result);
			}
		} while(!ans.equals("r")); 
		
	}
}


