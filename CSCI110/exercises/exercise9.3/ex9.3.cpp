#include <iostream>

using namespace std;

int main () {
    const int SIZE = 10;
    
    float temp;
    float values[SIZE] = { 32, 54, 67.5, 29, 35, 80, 115, 44.5, 100, 65};
    for (int i = 0; i < SIZE; ++i) {
        cout << "values[ " << i << " ] = " << values[i] << endl;
    }

    //insertion sort
    for (int i = 1; i < SIZE; ++i) {
        float key = values[i];
        int j = i;
        while (values[j-1] > key && j > 0) {
            values[j] = values[j - 1];
            i = j - 1;
        }
        values[j] = key;
    }

    //after sorting
    cout << "----------Sorted Array----------" << endl;
    for (int i = 0; i < SIZE; ++i) {
        cout << "values[ " << i << " ] = "  << values[i] << endl;
    }

    return 0;
}