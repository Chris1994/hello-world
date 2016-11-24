package calculator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class AppMenu {
	ArrayList<String> ops = new ArrayList<>();
	Calculator calc = new Calculator();
	DBConnection db;
	Scanner in = new Scanner(System.in);
	String back = "b", evaluate = "e", ans, operation = " ";
	private double first_num, second_num, result = 0.0, temp;
	String database = null, table = null;
	boolean logStatus = false;

	protected AppMenu() {
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
		System.out.println("\n   |   v1.0.2 - Created by Christopher Truebig   |");
		System.out.println("   |                                             |");
		System.out.println("   |        This program does mathematical       |");
		System.out.println("   | 	        computations and file IO         |");
		System.out.println("   | 	        and database interaction         |");
		System.out.println("   |______--------------------------------_______|\n");
	}

	protected void mainMenu() {
		System.out.println("\t\t [(c)alculator    ]\n\t\t [(p)eople        ]");
		System.out.println("\t\t [(e)xit program  ]");
		System.out.print(">>");
	}

	protected void calcMenu() {
		do {
			System.out.println("\t\t [(e)valuate       ]");
			System.out.println("\t\t [(r)eturn         ]");
			ans = in.nextLine();
			if (ans.equals(evaluate)) {
				System.out.print("num1: ");
				first_num = in.nextDouble();

				System.out.print("operation: ( + - * / ): ");
				operation = in.next();
				if (!ops.contains(operation)) {
					System.out.println("Invalid Input :(");
					in.nextLine(); // clear the buffer
					continue;
				}

				System.out.print("num2: ");
				second_num = in.nextDouble();

				in.nextLine();

				result = calc.eval(operation, result, first_num, second_num);
				System.out.println(first_num + " " + operation + " " + second_num + " = " + result);
			}
		} while (!ans.equals("r"));

	}

	protected void dataQueries() {
		do {
			System.out.println("\t\t [(o)pen database ]");
			System.out.println("\t\t [(r)eturn        ]");
			System.out.print(">>");
			ans = in.nextLine();
			if (ans.equals("o")) {
				try {
					db = new DBConnection();
					// Person p = new Person();
					String username = "", password = "";
					int count = 0;
					while (!logStatus) {
						if (count > 0)
							System.out.println("Username or password was incorrect.");
						System.out.print("Enter username: ");
						username = in.nextLine();
						System.out.print("Enter password: ");
						password = in.nextLine();

						logStatus = db.login(username, password);
						count++;
					}
					System.out.println("Correct username and password!");

					// get details of database name and
					// table required.
					System.out.print("Database name: ");
					database = in.nextLine();
					System.out.print("Table name: ");
					table = in.nextLine();

					db.connect(database); // open connection

					do {
						// menu for database operations
						// db.getTableNames();
						System.out.println("\t\t [(p)rint all records    ]");
						System.out.println("\t\t [(n)ew record           ]");
						System.out.println("\t\t [(r)eturn               ]");
						System.out.println(">>");

						ans = in.nextLine();
						if (ans.equals("r")) {
							ans = "";
							break;
						}
						switch (ans) {
						case "p":
							db.printAll(table);
							break;
						case "n":
							System.out.println("New record");
							break;
						case "r":
							continue;
						default:
							System.out.println("Invalid option chosen.");
						}
					} while (!ans.equals("r"));

					db.closeConnection(); // close connection after operations
					logStatus = false;

				} catch (SQLException e) {

					e.printStackTrace();
				}
			} else {
				System.out.println("Invalid option :(");
			}
		} while (!ans.equals("r"));
	}
}
