/*
Prolog
    a. Program Description: Seven Counter. The program rolls 2 dice 100 times and adds up the 2 values rolled. It will then count the amount of times a 7 was rolled.
    b. Author: Brandon Tsai
    c. Date/Time: 01/30/2025
    d. Input Variables: 
    e. Process Flow: The program generates a random number from 1-6 for d1 and d2, then it adds up d1 and d2 and if it equals 7 then the seven_counter increases by 1.
    f. Output Variables: d1, d2, total, seven_counter 
*/

#include <iostream>
#include <iomanip>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    srand(time(0));

    int seven_counter = 0;

    cout << "Value 1" << setw(10) << "Value 2" << setw(10) << "Total\n";

    for (int i = 1; i <= 100; i++) {
        int d1 = rand() % 6 + 1;
        int d2 = rand() % 6 + 1;
        int total = d1 + d2;

        cout << d1 << setw(10) << d2 << setw(12) << total << endl;

        if (total == 7) {
            seven_counter++;
        }
    }

    cout << "\nTotal number of 7s: " << seven_counter << endl;
    
    return 0;
}