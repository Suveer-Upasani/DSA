#include <iostream>
using namespace std;

void Bubble(int a[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                swap(a[j], a[j + 1]);
            }
        }
    }
}

int main() {
    int n;
    cout << "Enter Size of Array: ";
    cin >> n;
    int *a = new int[n];
    cout << "Enter Elements of Array: ";
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    Bubble(a, n);
    cout << "Sorted Array is: ";
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    delete[] a;
    return 0;
}
