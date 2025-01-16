#include <iostream>

using namespace std;

int main() {
    int i = 0;
    float count = 0;
    float total = 0;
    float avg = 0;
    int num;
    cout << "Please enter the number of iterations ";
    cin >> num;

    while (i < num)
    {
        cout << "I = " << i << endl;
        ++count;
        total = total + i;
        ++i;
    }

    cout << "Total = " << total << endl;
    avg = total / count;
    cout << "Average = " << avg << endl;
    system("pause");
    return 0;
}