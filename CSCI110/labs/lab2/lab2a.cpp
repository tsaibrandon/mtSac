/*
Prolog
    a. Program Description: This program asks the user to enter the amount of packages they purchased. Based on the amount it determines if they qualified for a discount and the total of their purchase.
    b. Author: Brandon Tsai
    c. Date/Time: 01/23/2025
    d. Input Variables: package_amt, answer
    e. Process Flow: The user inputs package_amt,then the program calculates the price_base to find how much it costs without a discount. Then the program checks to see if the user qualifies for a discount and based on the discount it calculates the discount and prints out the new_price. Then it asks the user if they would like to input a different package_amt and if "y" then the program loops.
    f. Output Variables: price_base, new_price
*/

#include <iostream>
#include <iomanip>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);
    
    string answer = "y";
    
    while (answer == "y") {
        const int PACKAGE_RETAIL = 99.00;
        int package_amt;
        int price_base;
        double discount;
        double new_price;

        cout << fixed << setprecision(2);

        cout << "How many packages did you purchase? ";
        cin >> package_amt;

        price_base = PACKAGE_RETAIL * package_amt;

        if (package_amt < 10) {
            cout << "You don't qualify for a discount." << "\n";
            cout << "Total: $" << price_base << "\n";
        } else if (package_amt >= 10 && package_amt <= 19) {
            discount = price_base * 0.2;
            new_price = price_base - (discount);
            cout << "You qualify for a 20% discount!" << "\n";
            cout << "Total: $" << new_price << "\n";
        } else if (package_amt >= 20 && package_amt <= 49) {
            discount = price_base * 0.3;
            new_price = price_base - (discount);
            cout << "You qualify for a 30% discount!" << "\n";
            cout << "Total: $" << new_price << "\n";
        } else if (package_amt >= 50 && package_amt <= 99) {
            discount = price_base * 0.4;
            new_price = price_base - (discount);
            cout << "You qualify for a 40% discount!" << "\n";
            cout << "Total: $" << new_price << "\n";
        } else if (package_amt >= 100) {
            discount = price_base * 0.5;
            new_price = price_base - (discount);
            cout << "You qualify for a 50% discount!" << "\n";
            cout << "Total: $" << new_price << "\n";
        }

        cout << "\n" << "Would you like to enter a different amount of packages? (y/n) ";
        cin >> answer;

        cout << "\n";
    }

    return 0;
}