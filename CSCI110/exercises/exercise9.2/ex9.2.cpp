#include <iostream>

using namespace std;

int main () {
    const int SIZE = 10;
    
    float temp;
    float values[SIZE] = { 32, 54, 67.5, 29, 35, 80, 115, 44.5, 100, 65};
    for (int i = 0; i < SIZE; ++i) {
        cout << "values[ " << i << " ] = " << values[i] << endl;
    }

    //bubble sort
    for (int i = 0; i < SIZE; ++i) {
        int min = i;
        for (int j = i + 1; j < SIZE; ++j) {
            if (values[j] > values[min]) {
                temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
            if (i != min) {
                temp = values[i];
                values[i] = values[min];
                values[min] = temp;
            }
        }
    }

    //after sorting
    cout << "----------Sorted Array----------" << endl;
    for (int i = 0; i < SIZE; ++i) {
        cout << "values[ " << i << " ] = "  << values[i] << endl;
    }

    return 0;
}