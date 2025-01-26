#include <iostream>

using namespace std;

int main() {
    int speed;
    int time;
    int distance;

    cout << "What is the speed of the vehicle in mph? ";
    cin >> speed;

    cout << "How many hours has it traveled? ";
    cin >> time;

    cout << "\n" << "Hour" << "\t" << "Distance Traveled" << endl;
    cout << "--------------------------" << endl;

    for (int i = 1; i <= time; i++) {
        distance = speed * i;

        cout << i << "\t\t" << distance << endl;
    }

    return 0;
}