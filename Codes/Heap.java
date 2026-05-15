import java.util.*;

public class heap {

    int[] h;
    int size;

    heap(int n) {
        h = new int[n];
        size = 0;
    }

    void insert(int x) {
        h[size] = x;
        int i = size;
        size++;

        while (i > 0 && h[(i - 1) / 2] > h[i]) {
            int temp = h[i];
            h[i] = h[(i - 1) / 2];
            h[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    int delete() {
        int min = h[0];
        h[0] = h[size - 1];
        size--;

        int i = 0;

        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int smallest = i;

            if (l < size && h[l] < h[smallest])
                smallest = l;

            if (r < size && h[r] < h[smallest])
                smallest = r;

            if (smallest != i) {
                int temp = h[i];
                h[i] = h[smallest];
                h[smallest] = temp;
                i = smallest;
            } else break;
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        heap h1 = new heap(n);

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            h1.insert(sc.nextInt());
        }

        System.out.println("Sorted output:");
        for (int i = 0; i < n; i++) {
            System.out.print(h1.delete() + " ");
        }
    }
}