/*
Prolog
    a. Program Description: Springfolk Amateur Golf Club Tournament. This program takes a list of names and scores and reads/prints it out.
    b. Author: Brandon Tsai
    c. Date/Time: 02/10/2025
    d. Input Variables: input_file, output_file, second_output
    e. Process Flow: The program prompts the user for an input_file, output_file, and second_output file. Then with the input_file it reads out all the first_name, last_name, and values. Then it would use an output.txt file to put all the information into a table.
    f. Output Variables: in_file, out_file, second_file, golf.dat, output.txt
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    string first_name;
    string last_name;
    double value;
    string input_file;
    string output_file;
    string second_output;
    ifstream in_file;
    ofstream out_file;
    ofstream second_file;
    
    cout << "Please enter the input file name: ";
    cin >> input_file; // /Users/tsaibrandon/Documents/input.dat
    
    in_file.open(input_file.c_str());
    
    if (in_file.fail()) {
        cout << "File not found" << endl;
        return 1;
    }
    
    cout << "Please enter the output file name: ";
    cin >> output_file; // /Users/tsaibrandon/Documents/golf.dat

    cout << "Please enter another output file name: ";
    cin >> second_output; // /Users/tsaibrandon/Documents/output.txt
    
    out_file.open(output_file.c_str());
    
    while (in_file >> first_name >> last_name >> value) {
        cout << "Their first name is " << first_name << " their last name is " << last_name << "and the value is " << value << endl;
        out_file << "Their first name is " << first_name << " their last name is " << last_name << "and the value is " << value << endl;
    }
    
    in_file.close();
    out_file.close();
    
    in_file.open(input_file.c_str());
    
    second_file.open(second_output.c_str());
    second_file << left << setw(20) << "Name" << right << setw(10) << "Score" << endl;
    second_file << "========================================" << endl;
    
    while (in_file >> first_name >> last_name >> value)
    {
        second_file << left << setw(20) << (first_name + " " + last_name) << right << setw(10) << value << endl;
    }

    in_file.close();
    out_file.close();
    second_file.close();

    return 0;
}


