#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    const int BASE_AMT = 48;
    const double BASE_SUGAR = 1.5;
    const double BASE_BUTTER = 1;
    const double BASE_FLOUR = 2.75;

    int cookieAmt;
    

    // calculations for one cookie
    double sugarCups = (BASE_SUGAR / BASE_AMT);
    double butterCups = (BASE_BUTTER / BASE_AMT);
    double flourCups = (BASE_FLOUR / BASE_AMT);

    // asks the user how many cookies they want to make
    cout << "How many cookies do you want to make?" << "\n";
    cin >> cookieAmt;

    // calculate the ingredients needed
    double sugarNeeded = sugarCups * cookieAmt;
    double butterNeeded = butterCups * cookieAmt;
    double flourNeeded = flourCups * cookieAmt;

    // display results
    cout << fixed << setprecision(2);
    cout << cookieAmt << " cookies needs:" << "\n";
    cout << "Sugar: " << sugarNeeded << " cups" << "\n";
    cout << "Butter: " << butterNeeded << " cups" << "\n";
    cout << "Flour: " << flourNeeded << " cups" << "\n";

    return 0;
    
}