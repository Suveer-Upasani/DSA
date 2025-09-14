#include <iostream>
using namespace std;
void Bubble(int a[], int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (a[i] <= a[j])
            {
                swap(a[i], a[j]);
            }
        }
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
    Bubble(a, n);
    cout << "Sorted Array is:";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
}