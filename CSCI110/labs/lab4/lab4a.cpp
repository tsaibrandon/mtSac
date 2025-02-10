/*
Prolog
    a. Program Description:  Speeding Violation Calculation. This program takes in the user's inputs and determines if they were speeding or not.
    b. Author: Brandon Tsai
    c. Date/Time: 02/06/2025
    d. Input Variables: speed_limit, driver_speed
    e. Process Flow: The program asks the user to input a speed_limit, then it will validate the input and if it invalid it will ask you for the speed_limit again. If the input was valid then the code will ask for the driver_speed and then check if the user was speeding or not. If the user was not speeding then the program will restart and ask for the speed_limit again. If the user was speeding then the program would print out how much over the speed_limit they were going.
    f. Output Variables: speeding
*/

#include <iostream>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    int speed_limit;
    int driver_speed;

    while (true) {
        //ask for the speed limit and driver's speed
        cout << "\nWhat is the speed limit (mph)? ";
        cin >> speed_limit;
        
        //validate speed limit input
        if (speed_limit < 20 || speed_limit > 70) {
            cout << "You have entered an invalid speed limit. Try Again.\n";
            continue;
        }

        cout << "How fast (mph) were you going? ";
        cin >> driver_speed;

        //validate driver speed input
        if (driver_speed <= speed_limit) {
            cout << "You were not speeding.\n";
            continue;
        }

        break;
    }

    //calculate and display the number of miles per hour over the speed limit
    int speeding;

    speeding = driver_speed - speed_limit;

    cout << "You were driving " << speeding << " mph over the speed limit.\n";

    return 0;
}