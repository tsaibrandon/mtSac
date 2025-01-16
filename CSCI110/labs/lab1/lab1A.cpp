/*
Prolog
    a. Program Description: This program asks for the user to enter each of the costs of the marketing campaign and the number of new customers acquired. Then it calculates the customer acquisition cost.
    b. Author: Brandon Tsai
    c. Date/Time: 01/16/2025
    d. Input Variables: advertising_cost, marketing_salaries, sales_commissions, new_customers
    e. Process Flow: Enter the advertising_cost, marketing_salaries, sales_commissions, new_customers. 
    f. Output Variables: acquisition_cost
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    float acquisition_cost;
    float advertising_cost;
    float marketing_salaries;
    float sales_commissions;
    float new_customers;

    cout << "Advertising cost = $";
    cin >> advertising_cost;

    cout << "Cost of Marketing Personnel Salaries = $";
    cin >> marketing_salaries;

    cout << "Cost of Sales Staff Commissions = $";
    cin >> sales_commissions;

    cout << "Number of New Customers = ";
    cin >> new_customers;

    acquisition_cost = (advertising_cost + marketing_salaries + sales_commissions) / new_customers;
    cout << "Customer Acquisition Cost = $" << acquisition_cost << endl;

    return 0;
}