/*
Prolog
    a. Program Description: Paint Job Estimator. This program calculates the total amount of materials and costs of what is needed for the paint job.
    b. Author: Brandon Tsai
    c. Date/Time: 01/30/2025
    d. Input Variables: square_feet, gallon_price
    e. Process Flow: The program asks the user to input square_feet and then the gallon_price. It then finds the initial_wall by square_feet / BASE_WALL, finds the total_paint_gallon by BASE_PAINT * initial wall, then finds total_labor_hour by BASE_LABOR_HOUR * initial_wall then finds total_paint_cost by total_paint_gallon * gallon_price, then finds total_labor_cost by BASE_LABOR_COST * total_labor_hour, and finally finds total_cost by total_paint_cost + total_labor_cost. Then it prints out all the totals.
    f. Output Variables: total_paint_gallon, total_labor_hour, total_paint_cost, total_labor_cost, total_cost
*/

#include <iostream>
#include <iomanip>

using namespace std;

void handle_winch(int sig) {}

void get_wall_space(double& square_feet){
    cout << "Enter the total wall space in square feet: ";
    cin >> square_feet;
    return;
}

void get_gallon_price(double& gallon_price) {
    cout << "Enter the cost for a gallon of paint: $";
    cin >> gallon_price;
    return;
}
 
int main() {
    signal(SIGWINCH, handle_winch);

    const double BASE_WALL = 115;
    const double BASE_PAINT = 1;
    const double BASE_LABOR_HOUR = 8;
    const double BASE_LABOR_COST = 20;
    double square_feet;
    double gallon_price;
    double initial_wall;
    double total_paint_gallon;
    double total_labor_hour;
    double total_paint_cost;
    double total_labor_cost;
    double total_cost;

    cout << fixed << setprecision(2);
    
    get_wall_space(square_feet);
    get_gallon_price(gallon_price);

    initial_wall = square_feet / BASE_WALL;
    total_paint_gallon = BASE_PAINT * initial_wall;
    total_labor_hour = BASE_LABOR_HOUR * initial_wall;
    total_paint_cost = total_paint_gallon * gallon_price;
    total_labor_cost = BASE_LABOR_COST * total_labor_hour;
    total_cost = total_paint_cost + total_labor_cost;

    cout << "\nTotal Gallons of Paint: " << total_paint_gallon << " gallons\n";
    cout << "Total Hours of Labor: " << total_labor_hour << " hours\n";
    cout << "Total Cost of Paint: $" << total_paint_cost << endl;
    cout << "Total Cost of Labor: $" << total_labor_cost << endl;
    cout << "Total Paint Job Cost: $" << total_cost << endl;

    return 0;
}   