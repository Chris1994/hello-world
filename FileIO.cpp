// writing on a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void welcome() {
    cout << "version 1.0 - Created by Christopher Truebig\n\n";
    cout << "Welcome to this little file program\n";
    cout << "You can read or write a file for now.\n";
    cout << "-------------------------------------\n";
}
void writeFile(string userName, string secondName, string date, string fileName) {
    ofstream myfile (fileName.c_str());
    if (myfile.is_open()) {
        myfile << "DOB:     " << date << "\n";
        myfile << "name:    " << userName << "\n";
        myfile << "surname: " << secondName << "\n";
        cout << "Written to file " << fileName;
        myfile.close();
    }
    else cout << "Unable to open file";
}

void readFile(string fileName) {
    string line;
    ifstream myfile (fileName.c_str());
    if (myfile.is_open()) {
        while ( getline (myfile,line) ) {
            cout << line << '\n';
        }
        myfile.close();
    }
    else cout << "Unable to open file";
}
double add(double first_num, double second_num){
    double result = first_num + second_num;
    return result;
}

double subtract(double first_num, double second_num){
    double result = first_num - second_num;
    return result;
}

bool validate() {
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
    string answer, home= "r", addition = "a", subtraction = "s", multiplication = "m";
    double first_num = 0.0, second_num = 0.0, result;
    bool validity = true;
    cout << "calculator version 1.0\n";
    do {

        cout << "(a)dd two numbers:\n";
        cout << "(s)ubtract two numbers:\n";
        cout << "(r)eturn to main menu:\n";
        cin >> answer;


        if (answer == addition){
            cout << "enter first number: ";
            cin >> first_num;

            validity = validate();// check input and if invalid return to main
            if (validity) {return;}

            cout << "enter second number: ";
            cin >> second_num;
            validity = validate();
            if(validity) {return;}
            result = add(first_num, second_num);
            cout << first_num << " + " << second_num << " = " << result << endl;

            cout << "add another number? ";
            cin >> answer;
            while (answer == "y") {
                cout << "enter a number: ";
                cin >> first_num;

                cout << result << " + " << first_num << " = " << result + first_num << endl;
                result += first_num;

                cout << "add another number? ";
                cin >> answer;
                validity = validate();
                if(validity) {return;}
            }
        }

        else if (answer == subtraction) {
            cout << "enter larger number: ";
            cin >> first_num;
            validity = validate();
            if(validity) {
                return;
            }
            cout << "enter smaller number: ";
            cin >> second_num;
            validity = validate();
            if(validity) {
                return;
            }
            if(second_num > first_num) {
                cout << "your first number is < second number\n";
                cout << "returning...\n";
                return;
            }
            result = subtract(first_num, second_num);
            cout << first_num << " - " << second_num << " = " << result << endl;
        }
        else if(answer == multiplication) {
            cout << "coming soon...\n";
        }
        else {
            return;
        }
    } while(answer != home);
}
int main () {
    string fileName, userName, secondName, date;
    string answer, read = "r", write = "w", exit = "e", calculations = "c";
    welcome();
    cout << "(r)ead file\n(w)rite a file\n(c)alculator\n(e)xit program\n";
    cout << ">> ";
    while(answer != "e") {

            cin >> answer;
            cout << "\n";
            if(answer == "e") {
                break;
            }
            else if(answer == read) {
                cout << "Please enter the name of the file: ";
                cin >> fileName;
                readFile(fileName);
            }
            else if(answer == write) {
                cout << "Please enter your name: *";
                cin >> userName;
                cout << "Please enter your surname: *";
                cin >> secondName;
                cout << "Enter the DOB please: *";
                cin >> date;
                cout << "Please create the name of the file: *";
                cin >> fileName;

                writeFile(userName, secondName, date, fileName);
            }
            else if(answer == calculations) {
                calculator();
            }

            else {
                cout << "invalid input... :[";
            }

    cout << "\n";
    cout << "(r)ead file\n(w)rite a file\n(c)alculator\n(e)xit program\n";
    cout << ">> ";
    }
    return 0;
}
