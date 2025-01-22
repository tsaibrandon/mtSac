#include <iostream>

using namespace std;

int sum(int first, int second) {
    int total = 0;
    
    cout << "First = " << first << endl;
    cout << "Second = " << second << endl;
    
    total = first + second;
    cout << "Total = " << total << endl;
    
    return total;
}

int main() {
    int first = 10;
    int second = 20;
    int return_value;

    return_value = sum(first, second);
    
    cout << "The return value is " << return_value << endl;
    
    // system("pause");
    return 0;
}