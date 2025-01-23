/*
Prolog
    a. Program Description: This program allows the user to enter a series of numbers that will end when "-99" is entered. It will then output the largest and smallest numbers entered, excluding "-99".
    b. Author: Brandon Tsai
    c. Date/Time: 01/23/2025
    d. Input Variables: numbers
    e. Process Flow: The program asks the user to input a series of numbers. It will keep allowing numbers to be entered until "-99" is entered. As numbers are being entered, the program compares the current largest and smallest number to the newest number. If it is larger than the current largest number the largest variable gets replaced with the new number. If the new number is smaller than the current smallest number then the smallest number variable gets replaced with the new number. Once "-99" is entered, the program displays the largest and smallest numbers.
    f. Output Variables: largest, smallest
*/

#include <iostream>
#include <iomanip>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    double numbers;
    double largest;
    double smallest;

    cout << "Enter a series of numbers (-99 being the end)" << "\n";
    cin >> numbers;

    if (numbers == -99) {
        cout << "No valid numbers were entered" << "\n";
        return 0;
    }
    
    largest = numbers;
    smallest = numbers;

    while (cin >> numbers) {
        if (numbers == -99) {
            break;
        } else if (numbers > largest) {
            largest = numbers;
        } else if (numbers < smallest) {
            smallest = numbers;
        }
    }

    cout << "Largest Number: " << largest << "\n";
    cout << "Smallest Number: " << smallest << "\n";

    return 0;
}