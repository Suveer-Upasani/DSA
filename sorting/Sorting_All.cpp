#include <iostream>
using namespace std;
void Bubble(int a[], int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (a[i] > a[j])
            {
                swap(a[i], a[j]);
            }
        }
    }
}
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
void Selection(int a[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int minIndex = i;
        for (int j = i + 1; j < n; j++)
        {
            if (a[j] < a[minIndex])
            {
                minIndex = j;
            }
        }
        if (minIndex != i)
        {
            swap(a[i], a[minIndex]);
        }
    }
}
int partition(int a[], int low, int high)
{
    int pivot = a[high];
    int i = low - 1;
    for (int j = low; j < high; j++)
    {
        if (a[j] <= pivot)
        {
            i++;
            swap(a[i], a[j]);
        }
    }
    swap(a[i + 1], a[high]);
    return i + 1;
}
void quickSort(int a[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(a, low, high);
        quickSort(a, low, pi - 1);
        quickSort(a, pi + 1, high);
    }
}

int main()
{
    int n;
    cout << "Enter Size of array:";
    cin >> n;
    int *a = new int[n];
    cout << "Enter Elements of Array:";
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    int choice;

    switch (choice)
        cout << "1. Bubble Sort" << endl;
    cout << "2. Insertion Sort" << endl;
    cout << "3. Selection Sort" << endl;
    cout << "4. Quick Sort" << endl;
    cout << "Enter your choice:";
    cin >> choice;
    {
    case 1:
        Bubble(a, n);
        break;
    case 2:
        Insertion(a, n);
        break;
    case 3:
        Selection(a, n);
        break;
    case 4:
        quickSort(a, 0, n - 1);
        break;
    default:
        cout << "Invalid choice!" << endl;
        return 0;
    }
}