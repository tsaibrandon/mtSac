#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    srand(time(0));

    int num1;
    int num2;
    int correct_answer;
    int user_answer;

    num1 = rand() % 201 + 100;
    num2 = rand() % 201 + 100;
    correct_answer = num1 + num2;

    cout << "\n" << "Solve the following question:" << endl;
    cout << "\n" << " " << num1 << "\n" << "+" << num2 << endl;
    cout << "-----" << endl;
    cin >> user_answer;

    if (user_answer == correct_answer) {
        cout << "\n" << "Congratulations!" << endl;
    } else {
        cout << "\n" << "Your answer is wrong." << endl;
        cout << "The correct answer is: " << correct_answer << endl;
    }

    return 0;
} 
