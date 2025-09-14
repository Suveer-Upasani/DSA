#include <iostream>
using namespace std;
void Insertion(int a[], int n)
{
    for (int i = 1; i < n; i++)
    {
        int key = a[i];
        int j = i - 1;
        while (j >= 0 && a[j] > key)
        {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;
    }
}
int main()
{
    int n;
    cout << "Enter Size of Array:";
    cin >> n;
    int *a = new int[n];
    cout << "Enter Elements of Array:";
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    Insertion(a, n);
    cout << "Sorted Array is:";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
}