/*
Prolog
    a. Program Description: Payroll. This program relates data that is entered by the user and using array subscripts. 
    b. Author: Brandon Tsai
    c. Date/Time: 02/06/2025
    d. Input Variables: emp_id, hours, pay_rate
    e. Process Flow: The program asks the user input all the emp_id and hours and stores it in the emp_id and hours array using the int_input. then it asks the user to input the pay_rate and stores it into the pay_rate array using the double_input. Then using the values in those arrays the program will use wage_calc to calculate the individual wages for each employee and then it will print out a table with the information.
    f. Output Variables: emp_id, hours, pay_rate, wages
*/

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
void wage_calc (int arr1[], double arr2[], double arr3[], int size) {    
    for (int i = 0; i < size; i++) {
        arr3[i] = arr1[i] * arr2[i];
    }
}

//print out the rows
void row_print(int arr1[], int arr2[], double arr3[], double arr4[], int size) {
    for(int i = 0; i < size; i++) {
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
    wage_calc(hours, pay_rate, wages, size);

    //print out table
    cout << left << setw(13) << "\nEmp ID" << setw(10) << "Hours" << setw(13) << "Pay Rates" << setw(12) << "Wages" << endl;
    cout << "--------------------------------------------\n";
    row_print(emp_id, hours, pay_rate, wages, size);
    
    return 0;
}




