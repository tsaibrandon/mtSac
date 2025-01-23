#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    srand(time(0));

    int seven_counter = 0;

    cout << "Value 1 " << "Value 2 " << "Total" << endl;

    for (int i = 1; i <= 100; i++) {
        int d1 = rand() % 6 + 1;
        int d2 = rand() % 6 + 1;
        int total = d1 + d2;

        cout << d1 << "\t" << d2 << "\t" << total << endl;

        if (total == 7) {
            seven_counter++;
        }
    }

    cout << "\n" << "Total number of 7s: " << seven_counter << endl;
    
    return 0;
}