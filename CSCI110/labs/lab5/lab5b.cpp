#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void handle_winch(int sig) {}

int main() {
    signal(SIGWINCH, handle_winch);

    string name;
    double value;
    string input_file;
    string output_file;
    ifstream in_file;
    ofstream out_file;
    
    cout << "Please enter the input file name: ";
    cin >> input_file;
    in_file.open(input_file.c_str());
    if (in_file.fail()) {
        cout << "File not found" << endl;
        return 1;
    }
    
    cout << "Please enter the input file name: ";
    cin >> output_file;
    out_file.open(output_file.c_str());
    while (in_file >> name >> value) {
        cout << "Name is " << name << " and value is " << value << endl;
        out_file << "Name is " << name << " and value is " << value << endl;
    }
    
    in_file.close();
    out_file.close();
    
    return 0;
}


