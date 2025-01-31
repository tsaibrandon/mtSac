/*
Prolog
    a. Program Description: Guess the Number. This program generates a random number 1-50 and the user needs to guess the correct number. 
    b. Author: Brandon Tsai
    c. Date/Time: 01/30/2025
    d. Input Variables: number
    e. Process Flow: The program uses srand() and rand() to generat a random number 1-50 and then the user inputs their answer. If the answer is to high or too low the program will let the user know. Once the answer is guessed correctly then the program ends and displays guess_count.
    f. Output Variables: guess_count
*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

void handle_winch(int sig) {}

int main () {
    signal(SIGWINCH, handle_winch);

    srand(time(0));

    int random_num = rand() % 50 + 1;
    int guess_count = 0;
    string guess = "wrong";

    while (guess == "wrong") {
        int number;

        cout << "Guess the number 1-50: ";
        cin >> number;

        if (number > random_num) {
            cout << "Your guess was too high! Try Again\n\n";
            guess_count++;
        } else if (number < random_num) {
            cout << "Your guess was too low! Try Again\n\n";
            guess_count++;
        } else {
            cout << "You guessed correctly!\n\n";
            guess_count++;
            guess = "right";
        }
    }

    cout << "Total Number of Guesses: " << guess_count << endl;
    
    return 0;
}