#include <iostream>
using namespace std;

struct Element {
    int row;
    int col;
    int val;
};

struct SparseMatrix {
    int rows, cols, num;
    Element *ele;
};

void create(SparseMatrix &s) {
    cin >> s.rows >> s.cols >> s.num;
    s.ele = new Element[s.num];
    for (int i = 0; i < s.num; i++) {
        cin >> s.ele[i].row >> s.ele[i].col >> s.ele[i].val;
    }
}

void display(const SparseMatrix &s) {
    int k = 0;
    for (int i = 0; i < s.rows; i++) {
        for (int j = 0; j < s.cols; j++) {
            if (k < s.num && s.ele[k].row == i && s.ele[k].col == j)
                cout << s.ele[k++].val << " ";
            else
                cout << "0 ";
        }
        cout << endl;
    }
}

int main() {
    SparseMatrix s;
    create(s);
    display(s);
    delete[] s.ele;
    return 0;
}
