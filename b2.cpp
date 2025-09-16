#include <iostream>
using namespace std;
void Binary(int a[], int n, int key)
{
    int s = 0;
    int e = n - 1;
    while (s <= e)
    {
        int mid = (e + s) / 2;
        if (a[mid] == key)
        {
            cout << "Found";
            return;
        }
        else if (a[mid] > key)
        {
            e = mid - 1;
        }
        else
        {
            s = mid + 1;
        }
    }
    cout << "Not found";
}
void Bubble(int a[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                swap(a[j], a[j + 1]);
            }
        }
    }
}
int main()
{
    int n;
    cout << "Enter size of array:";
    cin >> n;
    int *a = new int[n];
    cout << "Enter Elements:";
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    Bubble(a, n);
    cout << "Sorted List:";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }

    int key;
    cout << "Enter key to be searched:";
    cin >> key;

    Binary(a, n, key);
    delete[] a;
    return 0;
}
