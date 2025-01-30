#include <iostream>

using namespace std;

void handle_winch(int sig) {}

int main () {
    signal(SIGWINCH, handle_winch);

    srand(time(0));

    int random_num = rand() % 51;
    int guess_count = 0;
    string guess = "wrong";

    while (guess == "wrong") {
        int number;

        cout << "Guess the number 1-50: ";
        cin >> number;

        if (number > random_num) {
            cout << "Your guess was too high! Try Again" << "\n\n";
            guess_count++;
        } else if (number < random_num) {
            cout << "Your guess was too low! Try Again" << "\n\n";
            guess_count++;
        } else {
            cout << "You guessed correctly!" << "\n\n";
            guess_count++;
            guess = "right";
        }
    }

    cout << "Total Number of Guesses: " << guess_count << "\n\n";
    
    return 0;
}