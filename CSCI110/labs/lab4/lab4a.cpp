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
        cout << "How fast (mph) were you going? ";
        cin >> driver_speed;

        //validate the input
        if (speed_limit < 20 || speed_limit > 70) {
            cout << "You have entered an invalid speed limit. Try Again.\n";
            continue;
        }

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