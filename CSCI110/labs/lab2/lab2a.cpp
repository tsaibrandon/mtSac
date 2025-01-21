#include <iostream>
#include <iomanip>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);
    
    string answer = "y";
    
    while (answer == "y") {
        const int PACKAGE_RETAIL = 99.00;
        int packageAmt;
        int priceBase;
        double discount;
        double newPrice;

        cout << fixed << setprecision(2);

        cout << "How many packages did you purchase?" << "\n";
        cin >> packageAmt;

        priceBase = PACKAGE_RETAIL * packageAmt;

        if (packageAmt < 10) {
            cout << "\n" << "You don't qualify for a discount." << "\n";
            cout << "Total: $" << priceBase << "\n";
        } else if (packageAmt >= 10 && packageAmt <= 19) {
            discount = priceBase * 0.2;
            newPrice = priceBase - (discount);
            cout << "\n" << "You qualify for a 20% discount!" << "\n";
            cout << "Total: $" << newPrice << "\n";
        } else if (packageAmt >= 20 && packageAmt <= 49) {
            discount = priceBase * 0.3;
            newPrice = priceBase - (discount);
            cout << "\n" << "You qualify for a 30% discount!" << "\n";
            cout << "Total: $" << newPrice << "\n";
        } else if (packageAmt >= 50 && packageAmt <= 99) {
            discount = priceBase * 0.4;
            newPrice = priceBase - (discount);
            cout << "\n" << "You qualify for a 40% discount!" << "\n";
            cout << "Total: $" << newPrice << "\n";
        } else if (packageAmt >= 100) {
            discount = priceBase * 0.5;
            newPrice = priceBase - (discount);
            cout << "\n" << "You qualify for a 50% discount!" << "\n";
            cout << "Total: $" << newPrice << "\n";
        }

        cout << "\n" << "Would you like to enter a different amount of packages? (y/n)" << "\n";
        cin >> answer;

        cout << "\n";
    }

    return 0;
}