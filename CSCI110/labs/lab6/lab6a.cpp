/*
Prolog
    a. Program Description: Astronomy Helper. This program displays information about different planets.
    b. Author: Brandon Tsai
    c. Date/Time: 02/13/2025
    d. Input Variables: selected, answer
    e. Process Flow: The program repeatedly prompts the user to select a planet, displays its astronomical details (distance from the sun, mass, and surface temperature), and asks if they want to view another planet until they choose to exit.
    f. Output Variables: mercury_info, venus_info, earth_info, mars_info
*/

#include <iostream>

using namespace std;

void handle_winch(int sig) {}

void mercury(double arr[]) {
    cout << "\nMecury" << endl;
    cout << "Average distance from the sun: " << arr[0] << " million kilometers" << endl;
    cout << "Mass: " << arr[1] << "x 10^24" << "kg" << endl;
    cout << "Surface temperature: -" << arr[2] << " to " << arr[3] << " degrees Celsius" << endl;
}

void venus(double arr[]) {
    cout << "\nVenus" << endl;
    cout << "Average distance from the sun: " << arr[0] << " million kilometers" << endl;
    cout << "Mass: " << arr[1] << "x 10^24" << "kg" << endl;
    cout << "Surface temperature: " << arr[2] << " degrees Celsius" << endl;
}

void earth(double arr[]) {
    cout << "\nEarth" << endl;
    cout << "Average distance from the sun: " << arr[0] << " million kilometers" << endl;
    cout << "Mass: " << arr[1] << "x 10^24" << "kg" << endl;
    cout << "Surface temperature: -" << arr[2] << " to " << arr[3] << " degrees Celsius" << endl;
}

void mars(double arr[]) {
    cout << "\nMars" << endl;
    cout << "Average distance from the sun: " << arr[0] << " million kilometers" << endl;
    cout << "Mass: " << arr[1] << "x 10^24" << "kg" << endl;
    cout << "Surface temperature: -" << arr[2] << " to " << arr[3] << " degrees Celsius" << endl;
}

int main() {
    signal(SIGWINCH, handle_winch);

    int selected;
    double mercury_info[4] = {57.9, 3.31, 173, 430};
    double venus_info[3] = {108.2, 4.87, 472};
    double earth_info[4] = {149.6, 5.967, 50, 50};
    double mars_info[4] = {227.9, 0.6424, 140, 20};
    string answer;


    while(true) {
        cout << "Select a planet:\n" << "1. Mercury\n" << "2. Venus\n" << "3. Earth\n" << "4. Mars\n" << "5. Exit the program\n";
        cout << "\nEnter your selection 1 - 5 -> ";
        cin >> selected;

        if(selected < 1 || selected > 5) {
            cout << "\nInput not recognized. Please select a planet 1 - 5\n\n";
            continue;
        }

        if(selected == 1) {
            mercury(mercury_info);
        }else if(selected == 2) {
            venus(venus_info);
        }else if(selected == 3) {
            earth(earth_info);
        }else if(selected == 4) {
            mars(mars_info);
        }else {
            cout << "\nThanks for using the program!" << endl;
            break;
        }

        cout << "\nWould you like to select another planet? (y/n) ";
        cin >> answer;
        
        if (answer == "y") {
            continue;
        } else {
            cout << "\nThanks for using the program!" << endl;
            break;
        }
    }

    return 0;
}