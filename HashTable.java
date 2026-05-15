import java.util.Scanner;

class HashTable {
    int[] table;
    int size;

    HashTable(int s) {
        size = s;
        table = new int[size];

        // initialize with -1 (means empty)
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    int hash(int key) {
        return key % size;
    }

    void insert(int key) {
        int index = hash(key);

        while (table[index] != -1) {
            index = (index + 1) % size;
        }

        table[index] = key;
        System.out.println("Inserted");
    }

    void search(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != -1) {
            if (table[index] == key) {
                System.out.println("Found");
                return;
            }
            index = (index + 1) % size;

            if (index == start) break;
        }

        System.out.println("Not Found");
    }

    void delete(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != -1) {
            if (table[index] == key) {
                table[index] = -1;
                System.out.println("Deleted");
                return;
            }
            index = (index + 1) % size;

            if (index == start) break;
        }

        System.out.println("Not Found");
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        HashTable h = new HashTable(n);
        int ch, key;

        do {
            System.out.println("\n1.Insert 2.Search 3.Delete 4.Display 5.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    key = sc.nextInt();
                    h.insert(key);
                    break;

                case 2:
                    key = sc.nextInt();
                    h.search(key);
                    break;

                case 3:
                    key = sc.nextInt();
                    h.delete(key);
                    break;

                case 4:
                    h.display();
                    break;
            }
        } while (ch != 5);
    }
}