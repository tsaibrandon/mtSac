/*
Prolog
    a. Program Description: The program asks for the user's first then last name, then outputs a welcome message. Then it asks the user to input 2 numbers and then it will calculate the sum, difference, product and quotient. It will also compare the 2 numbers.
    b. Author: Brandon Tsai
    c. Date/Time: 01/16/2025
    d. Input Variables: f_name, l_name, first_variable, second_variable
    e. Process Flow: Enter the f_name then l_name, then first_variable and second_variable. Then the program adds, subtracts, multiplies, and divides the first_variable by the second_variable. Then it will check to see if the first_variable is larger or smaller than the second_variable and print out a message.
    f. Output Variables: full_name, sum, diff, prod, quot
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    string f_name;
    string l_name;
    string full_name;
    float first_variable = 10;
    float second_variable = 20;
    float sum;
    float diff;
    float prod;
    float quot;

    cout << "Please enter your first name: " << endl;
    cin >> f_name;
    cout << "Please enter your last name: " << endl;
    cin >> l_name;
    full_name = f_name + " " + l_name;
    cout << "Welcome, " << full_name << endl;

    cout << "Please enter the first value: " << endl;
    cin >> first_variable;

    cout << "Please enter the second value: " << endl;
    cin >> second_variable;

    sum = first_variable + second_variable;
    cout << "Sum = " << sum << endl;

    diff = first_variable - second_variable;
    cout << "Difference = " << diff << endl;

    prod = first_variable * second_variable;
    cout << "Product = " << prod << endl;

    quot = first_variable / second_variable;
    cout << "Quotient = " << quot << endl;

    if (first_variable > second_variable) 
        cout << "First value is greater than the second value" << endl;
    else
        cout << "Second value is greater than the first value" << endl;

    return 0;
    
}   