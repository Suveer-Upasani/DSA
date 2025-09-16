#include <iostream>
using namespace std;

void addPolynomials(int A[], int B[], int C[], int n) {
    for (int i = 0; i < n; i++) {
        C[i] = A[i] + B[i];
    }
}

void subtractPolynomials(int A[], int B[], int C[], int n) {
    for (int i = 0; i < n; i++) {
        C[i] = A[i] - B[i];
    }
}

void displayPolynomial(int poly[], int n) {
    for (int i = n - 1; i >= 0; i--) {
        if (poly[i] != 0) {
            cout << poly[i];
            if (i > 0) cout << "x^" << i << " ";
            if (i > 0 && poly[i-1] >= 0) cout << "+ ";
        }
    }
    cout << endl;
}

int main() {
    int n; 
    cout << "Enter degree of polynomial: ";
    cin >> n;
    n++;

    int A[n], B[n], result[n];
    int choice;

    cout << "Enter coefficients of first polynomial:\n";
    for (int i = 0; i < n; i++) cin >> A[i];

    cout << "Enter coefficients of second polynomial:\n";
    for (int i = 0; i < n; i++) cin >> B[i];

    cout << "\nChoose operation:\n1. Addition\n2. Subtraction\nEnter choice: ";
    cin >> choice;

    switch(choice) {
        case 1:
            addPolynomials(A, B, result, n);
            cout << "Result (Addition): ";
            displayPolynomial(result, n);
            break;
        case 2:
            subtractPolynomials(A, B, result, n);
            cout << "Result (Subtraction): ";
            displayPolynomial(result, n);
            break;
        default:
            cout << "Invalid choice!" << endl;
    }

    return 0;
}
