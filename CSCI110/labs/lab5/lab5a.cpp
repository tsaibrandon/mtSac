/*
Prolog
    a. Program Description: 
    b. Author: Brandon Tsai
    c. Date/Time: 02/10/2025
    d. Input Variables: int_input, target
    e. Process Flow: The program asks the user for an int_input and a target value and then throws it into sequential, then bubble, then binary search functions. Then it will print out what index the target was found and how many comparisons each search algorithm did.
    f. Output Variables: seq_index, seq_comparisons, bin_index, bin_comparisons
*/

#include <iostream>

using namespace std;

void handle_winch(int sig) {}

//one input with multiple values
int int_input(int arr[], int max_size, int& size) {
    size = 0;
    while (size < max_size && cin >> arr[size]) {
        size++;
        if (cin.peek() == '\n') {
            break;
        }
    }
    return size; 
}

//sequential search
int sequential(int arr[], int size, int target, int& comparisons) {
    comparisons = 0;
    for (int i = 0; i < size; i++) {
        comparisons++;
        if (arr[i] == target) {
            return i;
        }
    }
    return -1; 
}

//bubble sort
void bubble(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

//binary search
int binary(int arr[], int n, int target, int& comparisons) {
    comparisons = 0;
    int low = 0;
    int high = n - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        comparisons++;
        if (arr[mid] == target) {
            return mid; 
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

int main() {
    const int MAX_SIZE = 100;
    int integers[MAX_SIZE]; //32 54 67 29 35 80 115 44 100 65 37 51 70 26 40 105 33 83 112 41 95
    int size = 0;
    int target;
    int seq_comparisons;
    int seq_index;
    int bin_comparisons;
    int bin_index;

    cout << "Enter at least 20 integers: ";
    int_input(integers, MAX_SIZE, size);

    if (size < 20) {
        cout << "Error: You must enter at least 20 integers." << endl;
        return 1;
    }

    cout << "Enter the value you would like to search for: ";
    cin >> target;

    seq_index = sequential(integers, size, target, seq_comparisons);
    cout << "\nSequential Search\n";
    cout << "Index: " << seq_index << endl;
    cout << "Number of Comparisons: " << seq_comparisons << endl;

    bubble(integers, size);

    bin_index = binary(integers, size, target, bin_comparisons);
    cout << "\nBinary Search\n";
    cout << "Index: " << bin_index << endl;
    cout << "Number of Comparisons: " << bin_comparisons << endl;

    return 0;
}