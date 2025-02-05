#include <iostream>

using namespace std;

void handle_winch(int sig) {}

//allow for one input with multiple values
void int_input(int arr[], int max_size, int& size) {
    size = 0;
    while(cin >> arr[size]) {
        size++;
        if (cin.peek() == '\n') {
            break;
        }
    }
}

int main() {
    signal(SIGWINCH, handle_winch);

    
}