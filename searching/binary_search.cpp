#include <iostream>
using namespace std;
int Solution(int a[], int n, int key)
{
    int low = 0;
    int high = n - 1;

    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (a[mid] == key)
        {
            return mid;
        }
        if (a[mid] < key)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return -1;
}
int main()
{
    int n;
    cout << "Enter Size of Array: ";
    cin >> n;
    int *a = new int[n];
    cout << "Enter Elements of Array: ";
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    int key;
    cout << "Enter Element to be Searched: ";
    cin >> key;
    int result = Solution(a, n, key);
    if (result != -1)
    {
        cout << "Element found at index: " << result;
    }
    else
    {
        cout << "Element not found";
    }
}

// #include <iostream>
// using namespace std;

// bool isSorted(int a[], int n)
// {
//     for (int i = 0; i < n - 1; i++)
//     {
//         if (a[i] > a[i + 1])
//         {
//             return false;
//         }
//     }
//     return true;
// }

// int Solution(int a[], int n, int key)
// {
//     int low = 0;
//     int high = n - 1;

//     while (low <= high)
//     {
//         int mid = (low + high) / 2;
//         if (a[mid] == key)
//         {
//             return mid;
//         }
//         if (a[mid] < key)
//         {
//             low = mid + 1;
//         }
//         else
//         {
//             high = mid - 1;
//         }
//     }
//     return -1;
// }

// int main()
// {
//     int n;
//     cout << "Enter Size of Array: ";
//     cin >> n;

//     int *a = new int[n];
//     cout << "Enter Elements of Array: ";
//     for (int i = 0; i < n; i++)
//     {
//         cin >> a[i];
//     }

//     if (!isSorted(a, n))
//     {
//         cout << "Array is not sorted. Binary search cannot be performed." << endl;
//         delete[] a;
//         return 0;
//     }

//     int key;
//     cout << "Enter Element to be Searched: ";
//     cin >> key;

//     int result = Solution(a, n, key);
//     if (result != -1)
//     {
//         cout << "Element found at index: " << result;
//     }
//     else
//     {
//         cout << "Element not found";
//     }

//     delete[] a;
// }
