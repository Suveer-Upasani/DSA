import java.util.Scanner;

class HashT {
    int h[] = new int[10];
    int size = 10;

    HashT() {
        for (int i = 0; i < size; i++)
            h[i] = -1;   // empty
    }

    int hash(int x) {
        return x % size;
    }

    void insert(int x) {
        int i = hash(x);

        while (h[i] != -1) {
            i = (i + 1) % size;
        }

        h[i] = x;
    }

    void search(int x) {
        int i = hash(x);
        int start = i;

        while (h[i] != -1) {
            if (h[i] == x) {
                System.out.println("Found at index " + i);
                return;
            }
            i = (i + 1) % size;

            if (i == start)
                break;
        }

        System.out.println("Not Found");
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + h[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashT t = new HashT();

        int ch, x;

        do {
            System.out.println("\n1 Insert\n2 Search\n3 Display\n0 Exit");
            System.out.println("\n1 Insert\n2 Search\n3 Display\n0 Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    x = sc.nextInt();
                    t.insert(x);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    x = sc.nextInt();
                    t.search(x);
                    break;

                case 3:
                    t.display();
                    break;

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid");
            }

        } while (ch != 0);
    }
}