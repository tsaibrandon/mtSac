#include <iostream>

using namespace std;

int main() {
    int counter = 1;
    int num = 0;
    num = counter++; //postfix: num = counter, counter = counter +1
    cout << "counter = " << counter << endl;
    cout << "num = " << num << endl;
    counter = 1;
    num = ++counter; // prefix: counter = counter + 1, num = counter
    cout << "counter = " << counter << endl;
    cout << "num = " << num << endl;
    system("pause");
    return 0;
}