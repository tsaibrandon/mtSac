#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    double numbers;
    double largest;
    double smallest;

    cout << "Enter a series of numbers (-99 being the end)" << "\n";
    cin >> numbers;

    if (numbers == -99) {
        cout << "No valid numbers were entered" << "\n";
        return 0;
    }
    
    largest = numbers;
    smallest = numbers;

    while (cin >> numbers) {
        if (numbers == -99) {
            break;
        } else if (numbers > largest) {
            largest = numbers;
        } else if (numbers < smallest) {
            smallest = numbers;
        }
    }

    cout << "Largest Number: " << largest << "\n";
    cout << "Smallest Number: " << smallest << "\n";

    return 0;
}