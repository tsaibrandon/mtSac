#include <iostream>

using namespace std;

void handle_winch(int sig) {}

float total(float first, float second) {
    float sum = first + second;
    cout << "Total = " << sum << endl;
    
    return 0;
}

float diff(float first, float second) {
    float difference = first - second;
    cout << "Difference = " << difference << endl;
    
    return 0;
}

float prod(float first, float second) {
    float product = first * second;
    cout << "Product = " << product << endl;
    
    return 0;
}

float quot(float first, float second) {
    float quotient = first / second;
    cout << "Quotient = " << quotient << endl;
    
    return 0;
}

int main() {
    signal(SIGWINCH, handle_winch);
    
    float first;
    float second;
    
    cout << "Please enter the first value: ";
    cin >> first;

    cout << "Please enter the second value: ";
    cin >> second;

    total(first, second);
    diff(first, second);
    prod(first, second);
    quot(first, second);
    
    // system("pause");
    return 0;
}