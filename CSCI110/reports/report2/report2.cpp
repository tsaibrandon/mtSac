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

        cout << "\n" << "Would you like to continue? (y/n)" << "\n";
        cin >> answer;

        cout << "\n";
    }
    
    return 0;
}