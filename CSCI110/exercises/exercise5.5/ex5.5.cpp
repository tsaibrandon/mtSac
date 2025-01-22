#include <iostream>

using namespace std;

void exchange(int first, int second) {
    int temp;
    
    temp = first;
    first = second;

    cout << "(Exchange) First = " << first << endl;
    cout << "(Exchange) Second = " << second << endl;

    return;
}

void swap(int& first, int& second) {
    int temp;

    temp = first;
    first = second;
    second = temp;

    return;
}

int main() {
    int first = 10;
    int second = 20;

    cout << "(Before exchange) first = " << first << endl;
    cout << "(Before exchange) second = " << second << endl;

    exchange(first, second);

    cout << "(After Exchange) first = " << first << endl;
    cout << "(After Exchange) second = " << second << endl;

    swap(first, second);

    cout << "(After swap) first = " << first << endl;
    cout << "(After swap) second = " << second << endl;

    // system("pause");
    return 0;
}