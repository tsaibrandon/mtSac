/*
Prolog
    a. Program Description: The program determines the user's tax liability based on their marital status and their income.
    b. Author: Brandon Tsai
    c. Date/Time: 01/23/2025
    d. Input Variables: marital_status, income, answer
    e. Process Flow: The program starts by asking the user for their marital status then for their income. Then based on the marital_status and their income the program will determine how much tax RATE is needed to calculate their total_tax. Then the program asks if the user wants to continue and if "y" then the program loops.
    f. Output Variables: total_tax
*/

#include <iostream>
#include <string>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    string answer = "y";

    while(answer == "y") {
        const double RATE1 = 0.10;
        const double RATE2 = 0.25;
        const double RATE1_SINGLE_LIMIT = 32000;
        const double RATE1_MARRIED_LIMIT = 64000;
    
        double tax1 = 0;
        double tax2 = 0;

        cout << "Please enter s for single, or m for married: ";
        string marital_status;
        cin >> marital_status;

        double income;
        cout << "Please enter your income: $";
        cin >> income;

        if (marital_status == "s") {
            if (income <= RATE1_SINGLE_LIMIT) {
                tax1 = RATE1 * income;
            } else {
                tax1 = RATE1 * RATE1_SINGLE_LIMIT;
                tax2 = RATE2 * (income - RATE1_SINGLE_LIMIT);
            }
        } else {
            if (income <= RATE1_MARRIED_LIMIT) {
                tax1 = RATE1 * income;
            } else {
                tax1 = RATE1 * RATE1_MARRIED_LIMIT;
                tax2 = RATE2 * (income - RATE1_MARRIED_LIMIT);
            }
        }

        double total_tax = tax1 + tax2;

        cout << "The tax is $" << total_tax << endl;

        cout << "\n" << "Would you like to continue? (y/n) ";
        cin >> answer;

        cout << "\n";
    }
    
    return 0;
}