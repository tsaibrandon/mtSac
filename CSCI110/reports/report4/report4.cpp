#include <iostream>
#include <iomanip>

using namespace std;

//calculate row totals
const int COLUMNS = 3;
int row_total(int counts[][COLUMNS], int row) {
    int total = 0;
    for (int j = 0; j < COLUMNS; j++) {
        total += counts[row][j];
    }

    return total;
}

//calculate column totals
int column_total(int counts[][3], int num_rows, int column) {
    int total = 0;
    for (int i = 0; i < num_rows; i++) {
        total += counts[i][column];
    }

    return total;
}

int main() {
    const int COUNTRIES = 7;
    const int MEDALS = 3;

    string countries[] = {"Canada", "China", "Germany", "Korea", "Japan", "Russia", "United States"};
    int counts[COUNTRIES][MEDALS] = {
        {1, 0, 1},
        {1, 1, 0},
        {0, 0, 1},
        {1, 0, 0},
        {0, 1, 1},
        {0, 1, 1},
        {1, 1, 0}
    };

    cout << setw(15) << "Country" << setw(8) << "Gold" << setw(8) << "Silver" << setw(8) << "Bronze" << setw(8) << "Total" << endl;

    int grand_total = 0;

    for (int i = 0; i < COUNTRIES; ++i) {
        cout << setw(15) << countries[i];
        int row_sum = 0;
        for (int j = 0; j < MEDALS; ++j) {
            cout << setw(8) << counts[i][j];
            row_sum += counts[i][j];
        }

        cout << setw(8) << row_sum << endl;
        grand_total += row_sum;
    }

    cout << setw(15) << "Total";
    for (int j = 0; j < MEDALS; ++j) {
        int total = column_total(counts, COUNTRIES, j);
        cout << setw(8) << total;
    }

    cout << setw(8) << grand_total << endl;

    return 0;

}