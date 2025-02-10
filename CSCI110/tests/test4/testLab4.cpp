#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

int main() {
    string filename;
    ifstream input_file;
    ofstream output_file;
    int salesperson;
    double sale_amount;
    double total_all_sales = 0.0;
    int current_salesperson = -1;
    double current_total = 0.0;

    cout << fixed << setprecision(2);

    cout << "Please enter the input file: ";
    cin >> filename;

    input_file.open(filename.c_str());

    if (input_file.fail()) {
        cout << "File not found" << endl;
        return 1;
    }

    output_file.open("/Users/tsaibrandon/Documents/salesreport.txt");

    cout << setw(20) << left << "Salesperson ID" << setw(27) << right << "Sale Amount" << endl;
    cout << "================================================" << endl;

    output_file << setw(20) << left << "Salesperson ID" << setw(20) << right << "Sale Amount" << endl;
    output_file << setfill('=') << setw(40) << "" << setfill(' ') << endl;

    while (input_file >> salesperson >> sale_amount) {
        if (salesperson != current_salesperson) {
            if (current_salesperson != -1) {
                cout << setw(20) << left << "Total sales for this salesperson:" << setw(7) << right << "$" << current_total << endl;
                output_file << setw(20) << left << "Total sales for this salesperson:" << setw(7) << right << "$" << current_total << endl;
            }
            current_salesperson = salesperson;
            current_total = 0.0;
        }

        cout << setw(20) << left << salesperson << setw(20) << right << "$" << sale_amount << endl;
        output_file << setw(20) << left << salesperson << setw(20) << right << "$" << sale_amount << endl;

        current_total += sale_amount;
        total_all_sales += sale_amount;
    }

    if (current_salesperson != -1) {
        cout << setw(20) << left << "Total sales for this salesperson:" << setw(7) << right << "$" << current_total << endl;
        output_file << setw(20) << left << "Total sales for this salesperson:" << setw(7) << right << "$" << current_total << endl;
    }

    cout << setw(20) << left << "Total of all sales:" << setw(20) << right << "$" << total_all_sales << endl;
    output_file << setw(20) << left << "Total of all sales:" << setw(20) << right << "$" << total_all_sales << endl;

    input_file.close();
    output_file.close();

    return 0;
}