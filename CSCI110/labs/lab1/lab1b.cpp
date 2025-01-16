/*
Prolog
    a. Program Description: The program asks the user to enter the number of shares bought/sold, the buying price, the selling price and the percentage of commission to the broker for buying and selling stocks. Then it will calculate and display the total amount spent, the total amount made, the total amount of commission paid, and if Jaden made a profit or loss.
    b. Author: Brandon Tsai
    c. Date/Time: 01/16/2025
    d. Input Variables: bought_shares, buying_price, commission_buy, sold_shares, selling_price, commission_sell
    e. Process Flow:  Input the number of shares bought, then the price, then the commission percentage for buying. Then input the number of shares sold, the selling price and the commission percentage for selling. Then the program uses those values to calculate the total spent and made, then the commission totals, and then calculate how much money was made or lost.
    f. Output Variables: total_paid, stockbroker_buy, total_sold, stockbroker_sell, profit_loss
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    float bought_shares;
    float buying_price;
    float commission_buy;
    float sold_shares;
    float selling_price;
    float commission_sell;
    float total_paid;
    float stockbroker_buy;
    float total_sold;
    float stockbroker_sell;
    float profit_loss;

    cout << fixed << setprecision(2);

    cout << "How many shares did Jaden buy?" << "\n";
    cin >> bought_shares;

    cout << "How much did Jaden per stock?" << "\n";
    cin >> buying_price;

    cout << "What was the stockbroker commission percentage for buying stock?" << "\n";
    cin >> commission_buy;

    cout << "How many shares did Jaden sell?" << "\n";
    cin >> sold_shares;

    cout << "How much did Jaden sell each stock for?" << "\n";
    cin >> selling_price;

    cout << "What was the stockbrocker commmission percentage for selling stock?" << "\n";
    cin >> commission_sell;

    total_paid = bought_shares * buying_price;
    
    stockbroker_buy = total_paid * (commission_buy / 100);
    
    total_sold = sold_shares * selling_price;
    
    stockbroker_sell = total_sold * (commission_sell / 100);

    profit_loss = total_sold - total_paid - (stockbroker_buy + stockbroker_sell);

    cout << "\n" << "Total Amount Paid: $" << total_paid << "\n";
    cout << "Total Commission Paid for Buying: $" << stockbroker_buy << "\n";
    cout << "Total Amount Sold: $" << total_sold << "\n";
    cout << "Total Commission Paid for Selling: $" << stockbroker_sell << "\n";

    if (profit_loss >= 0) {
        cout << "Total Profit/Loss: $" << profit_loss << "\n";
    } else {
        profit_loss = profit_loss * -1;
        cout << "Total Profit/Loss: -$" << profit_loss << "\n";
    }

    return 0;
}