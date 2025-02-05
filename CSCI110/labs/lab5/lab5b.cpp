#include <iostream>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    
}