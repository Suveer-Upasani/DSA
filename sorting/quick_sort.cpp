#include <iostream>
using namespace std;
void quick(int a[], int s, int e)
{
    if (s >= e)
    {
        return;
    }

    int pivot = a[e];
    int pIndex = s;

    for (int i = s; i < e; i++)
    {
        if (a[i] <= pivot)
        {
            swap(a[i], a[pIndex]);
            pIndex++;
        }
    }
    swap(a[pIndex], a[e]);

    quick(a, s, pIndex - 1);
    quick(a, pIndex + 1, e);
}
int main()
{
    int n;
    cout << "Enter Size of array: ";
    cin >> n;

    int *a = new int[n];
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    quick(a, 0, n - 1);

    cout << "Sorted array is: ";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;

    delete[] a;
    return 0;
}
