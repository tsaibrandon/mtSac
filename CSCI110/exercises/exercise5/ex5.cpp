#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main() {
    const int COLUMNS = 4;
    const double ROW = 10;

    // print table header
    for (int j = 1; j <= COLUMNS; j++) {
        cout << setw(10) << j;
    }
    cout << endl;

    for (int j = 1; j <= COLUMNS; j++) {
        cout << setw(10) << "x ";
    }
    cout << endl << endl;

    // print table body
    for (double i = 1; i <= ROW; i++) {
        // print table row
        for (int j = 1; j <= COLUMNS; j++) {
            cout << setw(10) << pow(i, j);
        }
    cout << endl;
    }

    return 0;   
}




