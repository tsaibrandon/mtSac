#include <iostream>
#include <string>

using namespace std;

void string_input(string arr[], int max_size, int& size) {
    size = 0;
    while (size < max_size && cin >> arr[size]) {
        size++;
        if (cin.peek() == '\n') {
            break;
        }
    }
}

int main() {
    string correct_answers[20] = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
    string student_answers[20]; //B D A A B A B A C A B C D A B C C B D D
    int correct_count = 0;
    int incorrect_questions[20];
    int incorrect_count = 0;
    int size = 0;

    cout << "Enter your answers for all 20 questions (A, B, C, or D), separated by spaces: " << endl;
    string_input(student_answers, 20, size);

    for (int i = 0; i < 20; i++) {
        if (student_answers[i] == correct_answers[i]) {
            correct_count++;
        } else {
            incorrect_questions[incorrect_count] = i + 1;
            incorrect_count++;
        }
    }

    if (correct_count >= 15) {
        cout << "\nYou Passed!" << endl;
    } else {
        cout << "\nYou Failed!" << endl;
    }

    cout << "Total Correct Answers: " << correct_count << endl;
    cout << "Total Incorrect Answers: " << (20 - correct_count) << endl;
    cout << "Questions Answered Incorrectly: ";
        for (int i = 0; i < incorrect_count; i++) {
            cout << incorrect_questions[i];
            if (i < incorrect_count - 1) {
                cout << ", ";
            }
        }
        cout << endl;

    return 0;
}