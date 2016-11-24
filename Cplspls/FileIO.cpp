/*
This is a program that can do mathematical computations
which are (\+-*) and can read files and create new files
*/
#include <iostream>
#include <fstream>
#include <string>

struct person {
	std::string name;
	std::string surname;
	std::string dob;
	std::string fileName;
};

void welcome();
bool validate();
void calculator();
void writeFile(const person & p);
void readFile(std::string fileName);
template <typename T>
void eval(char op, T &result, T first_num, T second_num);
template <typename T>
void eval(char op, T &result, T number);

int main () {
    std::string fileName, userName, secondName, date;
    std::string answer, read = "r", write = "w", exit = "e", calculations = "c";
    welcome();
    std::cout << "\t\t [(r)ead file]\n\t\t [(w)rite a file]\n\t\t [(c)alculator]\n\t\t [(e)xit program]\n";
    std::cout << ">> ";
    while(answer != "e") {
        std::cin >> answer;
        std::cout << "\n";
        if(answer == "e") {
            break;
        }
        else if(answer == read) {
            std::cout << "Please enter the name of the file: ";
            std::cin >> fileName;
            readFile(fileName);
        }
        else if(answer == write) {
			person record;
            std::cout << "Please enter your name: *";
            std::cin >> record.name;
            std::cout << "Please enter your surname: *";
            std::cin >> record.surname;
            std::cout << "Enter the DOB please: *";
            std::cin >> record.dob;
            std::cout << "Please create the name of the file: *";
            std::cin >> record.fileName;
            writeFile(record);
            }
            else if(answer == calculations) {
            	calculator();
            }
            else {
                std::cout << "invalid input... :[";
            }

    std::cout << "\n";
    welcome();
    std::cout << "\t\t [(r)ead file]\n\t\t [(w)rite a file]\n\t\t [(c)alculator]\n\t\t [(e)xit program]\n";
    std::cout << ">> ";
    }
    return 0;
}
void welcome() {
	std::cout << "\n   |---------------------------------------------|\n";
    std::cout << "\n   |   v1.0.1 - Created by Christopher Truebig   |\n";
	std::cout << "   |                                             |\n";
    std::cout << "   |        This program does mathematical       |\n";
    std::cout << "   | 	        computations and file IO         |\n";
    std::cout << "   |______--------------------------------_______|\n\n";
}
void writeFile(const person & p) {
    std::ofstream myfile (p.fileName.c_str());
    if (myfile.is_open()) {
        myfile << "DOB:     " << p.dob << "\n";
        myfile << "name:    " << p.name << "\n";
        myfile << "surname: " << p.surname << "\n";
        std::cout << "Written to file " << p.fileName;
        myfile.close();
    }
    else std::cout << "Unable to open file";
}

void readFile(std::string fileName) {
    std::string line;
    std::ifstream myfile (fileName.c_str());
    if (myfile.is_open()) {
        while ( getline (myfile,line) ) {
            std::cout << line << '\n';
        }
        myfile.close();
    }
    else std::cout << "Unable to open file";
}
template <typename T>
void eval(char op, T &result, T first_num, T second_num) {
	switch(op) {
		case '*':
			result = first_num * second_num;
			break;
		case '+':
			result = first_num + second_num;
			break;
		case '-':
			result = first_num - second_num;
			break;
		case '/':
			result = first_num /second_num;
			break;
		default:
			std::cout << "Invalid operation! :(" << std::endl;
	}
}
template <typename T>
void eval(char op, T &result, T number) {
	switch(op) {
		case '*':
			result *= number;
			break;
		case '+':
			result += number;
			break;
		case '-':
			result -= number;
			break;
		case '/':
			result /= number;
			break;
		default:
			std::cout << "Invalid operation! :(" << std::endl;
	}
}

bool validate() {
    using namespace std;
    if (cin.fail()) {
        cin.clear();
        cin.ignore();
        cout << "Invalid\n";
        cout << "returning to main menu...\n";
        return true;
    }
    else {
        return false;
    }
}
void calculator() {
    std::string evaluate = "e", answer, home = "r";
	char operation = ' ';
	double first_num = 0.0, second_num = 0.0, result = 0.0, temp = 0.0;
    bool validity = true;
    std::cout << "calculator version 1.0\n";
    do {
		std::cout << "(e)valuate two numbers\n";
		std::cout << "(r)eturn to main menu:\n";
		std::cin >> answer;
		
		if (answer == evaluate) {
			result = 0;
            std::cout << "number1: ";
            std::cin >> first_num;

            validity = validate();// check input and if invalid return to main
            if (validity) {return;}
			
			std::cout << "select operation ( * / + - ): ";
            std::cin >> operation;

            validity = validate();// check input and if invalid return to main
            if (validity) {return;}

            std::cout << "number2: ";
            std::cin >> second_num;
            validity = validate();
            if(validity) {return;}
			
            eval(operation, result, first_num, second_num);// ******
            std::cout << first_num << " " << operation << " " << second_num << " = " << result << std::endl;
			
			if (operation == '*') {
				std::cout << "multiply another? ";
			}
			else if(operation == '+') {
				std::cout << "add again? ";
			}
			else if(operation == '-') {
				std::cout << "subtract again? ";
			}
			
			else {
				std::cout << "divide again? ";
			}
			
			std::cin >> answer;		// get input
            while (answer == "y") {
                std::cout << "number: ";
                std::cin >> first_num;
				temp = result;
				eval(operation, result, first_num);
                std::cout << temp << " " << operation << " " <<  first_num << " = " << result << std::endl;
				                
                std::cout << "another operation? ";
                std::cin >> answer;
                validity = validate();
                if(validity) {return;}
            }			
		}		
        else {
			result = 0;
            return;
        }
    } while(answer != home);
}

