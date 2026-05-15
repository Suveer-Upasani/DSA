// import java.util.Scanner;

// public class Main {
//     static void heapify(int a[], int n, int i) {
//         int largest = i;
//         int l = 2 * i + 1;
//         int r = 2 * i + 2;

//         if (l < n && a[l] > a[largest]) largest = l;
//         if (r < n && a[r] > a[largest]) largest = r;

//         if (largest != i) {
//             int t = a[i];
//             a[i] = a[largest];
//             a[largest] = t;
//             heapify(a, n, largest);
//         }
//     }

//     static void heapSort(int a[], int n) {
//         for (int i = n / 2 - 1; i >= 0; i--) {
//             heapify(a, n, i);
//         }

//         for (int i = n - 1; i > 0; i--) {
//             int t = a[0];
//             a[0] = a[i];
//             a[i] = t;
//             heapify(a, i, 0);
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int a[] = new int[n];

//         for (int i = 0; i < n; i++) {
//             a[i] = sc.nextInt();
//         }

//         heapSort(a, n);

//         for (int i = 0; i < n; i++) {
//             System.out.print(a[i] + " ");
//         }
//     }
// }


import java.util.Scanner;

public class Main {

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;

        if (l < n && a[l] > a[largest]) largest = l;
        if (r < n && a[r] > a[largest]) largest = r;

        if (largest != i) {
            swap(a, i, largest);
            heapify(a, n, largest);
        }
    }

    static void heapSort(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        heapSort(a);

        for (int x : a)
            System.out.print(x + " ");

        sc.close();
    }
}