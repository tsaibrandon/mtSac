#include <iostream>

using namespace std;

float sum(float no_1, float no_2) {
    float total = no_1 + no_2;
    cout << "Total = " << total << endl;
    
    return 0;
}

float diff(float no_1, float no_2) {
    float difference = no_1 - no_2;
    cout << "Difference = " << difference << endl;
    
    return 0;
}

int main() {
    float first = 10;
    float second = 20;
    
    sum(first, second);
    diff(first, second);
    
    // system("pause");
    return 0;
}