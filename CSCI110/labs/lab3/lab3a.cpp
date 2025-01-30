#include <iostream>
#include <iomanip>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    const int BASE_WALL = 115;
    const int BASE_PAINT = 1;
    const int BASE_LABOR_HOUR = 8;
    const double BASE_LABOR_COST = 20;
    int square_feet;
    double gallon_price;
    int initial_wall;
    int total_paint_gallon;
    int total_labor_hour;
    double total_paint_cost;
    double total_labor_cost;
    double total_cost;

    cout << fixed << setprecision(2);
    
    cout << "Enter the total wall space in square feet: ";
    cin >> square_feet;

    cout << "Enter the cost for a gallon of paint: $";
    cin >> gallon_price;

    initial_wall = square_feet / BASE_WALL;
    total_paint_gallon = BASE_PAINT * initial_wall;
    total_labor_hour = BASE_LABOR_HOUR * initial_wall;
    total_paint_cost = total_paint_gallon * gallon_price;
    total_labor_cost = BASE_LABOR_COST * total_labor_hour;
    total_cost = total_paint_cost + total_labor_cost;

    cout << "\n" << "Total Gallons of Paint: " << total_paint_gallon << " gallons" << "\n";
    cout << "Total Hours of Labor: " << total_labor_hour << " hours" << "\n";
    cout << "Total Cost of Paint: $" << total_paint_cost << "\n";
    cout << "Total Cost of Labor: $" << total_labor_cost << "\n";
    cout << "Total Paint Job Cost: $" << total_cost << "\n\n";

    return 0;
}   