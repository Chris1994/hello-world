package calculator;

class Calculator {
	
	public double eval(String op, double result, double f_num, double s_num) {
		switch(op) {
			case "+":
				result = f_num + s_num;
				break;
			case "-":
				result = f_num - s_num;
				break;
			case "*":
				result = f_num * s_num;
				break;
			case "/":
				result = f_num / s_num;
				break;
			default:
				System.out.println("Invalid operation! :(");
		}
		return result;
	}	
	public double eval(String op, double result, double num) {
		switch(op) {
			case "+":
				result += num;
				break;
			case "-":
				result -= num;
				break;
			case "*":
				result *= num;
				break;
			case "/":
				result /= num;
				break;
			default:
				System.out.println("Invalid operation! :(");
		}
		return result;
	}
}
