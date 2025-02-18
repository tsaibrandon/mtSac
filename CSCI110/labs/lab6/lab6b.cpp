/*
    a.Program Description: Alphabetic Telephone Number Translator. This program translates numbers in a phone number into the number.
    b.Author: Brandon Tsai
    c.Input Variables: phone_number
    d.Process Flow: The program repeatedly prompts the user to enter a 10-character telephone number, converts any alphabetic characters to their corresponding numeric keypad digits, displays the translated number, and asks if they want to enter another, continuing until the user chooses to exit.
    e.Output Validation: phone_number
*/

#include <iostream>
#include <cctype> 

using namespace std;

char translate(char ch)
{
    ch = toupper(ch);
    if (ch >= 'A' && ch <= 'C') return '2';
    if (ch >= 'D' && ch <= 'F') return '3';
    if (ch >= 'G' && ch <= 'I') return '4';
    if (ch >= 'J' && ch <= 'L') return '5';
    if (ch >= 'M' && ch <= 'O') return '6';
    if (ch >= 'P' && ch <= 'S') return '7';
    if (ch >= 'T' && ch <= 'V') return '8';
    if (ch >= 'W' && ch <= 'Z') return '9';
    return ch;
}

int main()
{
    string answer;

    do
    {
        string phone_number;

        cout << "Please enter a 10-character telephone number (XXX-XXX-XXXX): ";
        cin >> phone_number;

        for (int i = 0; i < phone_number.length(); i++)
        {
            phone_number[i] = translate(phone_number[i]);
        }

        cout << "Here is the translated number: " << phone_number << endl << endl;

        cout << "Would you like to enter another? (y/n) ";
        cin >> answer; 
        cout << endl;
        
        if (answer != "y")
        {
            break;
        }
    } while (answer == "y");

    return 0;
}