#include <iostream>

using namespace std;

void handle_winch(int sig) {}

void total(float first, float second) {
    float sum = first + second;
    cout << "Total is = " << sum << endl;
    
    return;
}

void diff(float first, float second) {
    float difference = first - second;
    cout << "Difference is = " << difference << endl;
    
    return;
}

void prod(float first, float second) {
    float product = first * second;
    cout << "Product is = " << product << endl;
    
    return;
}

void quot(float first, float second) {
    float quotient = first / second;
    cout << "Quotient is = " << quotient << endl;
    
    return;
}

void input_process(float& first, float& second) {
    cout << "Please enter the first value: ";
    cin >> first;

    cout << "Please enter the second value: ";
    cin >> second;
    
    return;
}

void output_process(float first, float second) {
    total(first, second);
    diff(first, second);
    prod(first, second);
    quot(first, second);
    
    return;
}

int main() {
    signal(SIGWINCH, handle_winch);
    
    float first = 0;
    float second = 0;
    input_process(first, second);
    output_process(first, second);
    
    // system("pause");
    return 0;
}