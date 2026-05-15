package Codes;

import java.util.Scanner;

public class New {

    static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void printArray(int[] a){
        for(int x : a){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void heapify(int[] a, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < n && a[l] > a[largest]) largest = l;
        if(r < n && a[r] > a[largest]) largest = r;

        if(largest != i){
            swap(a, i, largest);
            System.out.print("After heapify swap: ");
            printArray(a);

            heapify(a, n, largest);
        }
    }

    static void heapSort(int[] a){
        int n = a.length;

        System.out.println("Initial Array:");
        printArray(a);

        // Build Heap
        System.out.println("\nBuilding Max Heap:");
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(a, n, i);
        }

        System.out.print("Max Heap formed: ");
        printArray(a);

        // Heap Sort
        System.out.println("\nSorting Process:");
        for(int i = n - 1; i > 0; i--){
            swap(a, 0, i);

            System.out.print("After swapping root with index " + i + ": ");
            printArray(a);

            heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        heapSort(a);

        System.out.println("\nFinal Sorted Array:");
        printArray(a);

        sc.close();
    }
}