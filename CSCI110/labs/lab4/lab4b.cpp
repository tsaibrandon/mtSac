#include <iostream>
#include <iomanip>

using namespace std;

void handle_winch(int sig) {}

//allow for one input with multiple values
void int_input(int arr[], int max_size, int& size) {
    size = 0;
    while(size < max_size && cin >> arr[size]) {
        size++;
        if (cin.peek() == '\n') {
            break;
        }
    }
}

void double_input(double arr[], int max_size, int& size) {
    size = 0;
    while(size < max_size && cin >> arr[size]) {
        
        size++;
        if (cin.peek() == '\n') {
            break;
        }
    }
}

//wage calculation
void wage_calc (int arr1[], double arr2[], double arr3[], int max_size) {    
    for (int i = 0; i < max_size; i++) {
        arr3[i] = arr1[i] * arr2[i];
    }
}

//print out the rows
void row_print(int arr1[], int arr2[], double arr3[], double arr4[], int max_size) {
    for(int i = 0; i < max_size; i++) {
        cout << left << setw(12) << arr1[i] << setw(10) << arr2[i] << "$"  << setw(12) << arr3[i] << "$"  << setw(12) << arr4[i] << endl;
    }
}

int main() {
    signal(SIGWINCH, handle_winch);

    const int MAX_SIZE = 100;
    int emp_id[MAX_SIZE]; //56588 45201 78951 87775 84512 13028 75804
    int hours[MAX_SIZE]; //45 35 55 62 42 51 53 
    double pay_rate[MAX_SIZE]; //25.5 22.5 24.5 27.5 31.5 32.5 28.5 
    double wages[MAX_SIZE];
    int size = 0;

    cout << fixed << setprecision(2);

    //get inputs emp id, hours, and payrate
    cout << "Enter all of the employee IDs (seperated by spaces): ";
    int_input(emp_id, MAX_SIZE, size);
    size = 0;
    cout << "Enter all the employee hours (seperated by spaces): ";
    int_input(hours, MAX_SIZE, size);
    size = 0;
    cout << "Enter all the employee payrates (seperated by spaces): ";
    double_input(pay_rate, MAX_SIZE, size);

    //calculate employee wages
    wage_calc(hours, pay_rate, wages, MAX_SIZE);

    //print out table
    cout << left << setw(13) << "\nEmp ID" << setw(10) << "Hours" << setw(13) << "Pay Rates" << setw(12) << "Wages" << endl;
    cout << "--------------------------------------------\n";
    row_print(emp_id, hours, pay_rate, wages, MAX_SIZE);
    
    return 0;
}




