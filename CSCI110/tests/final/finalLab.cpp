#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    double const PLAN1 = 560;
    double const PLAN2 = 1095;
    double const PLAN3 = 1500;
    int plan_selected;
    int semester_amt;
    double total;

    cout << fixed << setprecision(2);

    cout << "University Meal Plan Selector" << endl;
    cout << "-----------------------------" << endl;
    cout << "1. Plan 1: 7 meals per week for $560 per semester\n" << "2. Plan 2: 14 meals per week for $1,095 per semester\n" << "3. Plan 3: Unlimited meals for $1,500 per semester" << endl;

    while(true) {
        cout << "\nSelect a meal plan: ";
        cin >> plan_selected;

        if(plan_selected < 1 || plan_selected > 3) {
            cout << "Invalid plan. Please select a plan from the menu above.\n";
            continue;
        }

        break;
    }

    cout << "Input the number of semesters for the meal plan: ";
    cin >> semester_amt;

    if(plan_selected == 1) {
        total = PLAN1 * semester_amt;
    } else if (plan_selected == 2) {
        total = PLAN2 * semester_amt;
    } else {
        total = PLAN3 * semester_amt;
    }

    cout << "\nYour total price for " << semester_amt << " semesters is $" << total << endl;

    return 0;
}