/*
    Program: Elevator Program
    Author: Brandon Tsai
*/

#include <iostream>
#include <string>

using namespace std;

int main() {
    int floor;
    string answer;

    // the following statements check various input errors
    while(true) {
        cout << "Please enter the floor number: ";
        cin >> floor;

        if (cin.fail()) {
            cout << "Error: Not an integer." << endl;
            cin.clear();
            cin.ignore();
            return -1;
        } else if (floor == 13) {
            cout << "Error: there is no thirteenth floor." << endl;
        } else if (floor <= 0 || floor > 20) {
            cout << "Error: The floor must be between 1 and 20." << endl;
        } else {
            continue;
        }

        cout << "Do you want to continue (y/n)? " << endl;
        cin >> answer;

        if (answer != "y") {
            cout << "Thank you for using this application, bye!" << endl;
            break;
        }
    }

    // now we know that the input is valid
    int actual_floor;

    if (floor > 13) {
        actual_floor = floor - 1;
    } else {
        actual_floor = floor;
    }

    cout << "The elevator will trabel to the actual floor " << actual_floor << endl;

    return 0;
}