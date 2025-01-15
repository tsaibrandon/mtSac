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

    do
    {
        cout << "I = " << i << endl;
        ++count;
        total = total + i;
        ++i;
    } while (i < num);
    
    // for (int i = 0; i < num; i++)
    // {
    //     cout << "I = " << i << endl;
    //     ++count;
    //     total = total + i;
    // }

    // while (i < num)
    //     {
    //         cout << "I = " << i << endl;
    //         ++count;
    //         total = total + i;
    //         ++i;
    //     }

    cout << "Total = " << total << endl;
    avg = total / count;
    cout << "Average = " << avg << endl;
    system("pause");
    return 0;
}