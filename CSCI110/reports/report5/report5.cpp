/*
Prolog
    a. Program Description: This program takes an input and makes an output.txt
    b. Author: Brandon Tsai
    c. Date/Time: 02/10/2025
    d. Input Variables: filename
    e. Process Flow: The program prompt the user for an input.dat and makes an output.txt
    f. Output Variables: output.txt
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    string name;
    double value;
    string filename;
    ifstream in_file;
    ofstream out_file;
    
    cout << "Please enter the input file name: ";
    cin >> filename; // /Users/tsaibrandon/Documents/input.dat

    in_file.open(filename.c_str());
    if (in_file.fail()) {
        cout << "File not found" << endl;
        return 1;
    }
    
    out_file.open("/Users/tsaibrandon/Documents/output.txt");
    while (in_file >> name >> value) {
        cout << "Name is " << name << " and value is " << value << endl;
        out_file << "Name is " << name << " and value is " << value << endl;
    }
    
    in_file.close();
    out_file.close();
    
    return 0;
}