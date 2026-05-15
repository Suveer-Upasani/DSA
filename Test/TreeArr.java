package Test;

import java.util.*;

class TreeArr {
    int t[] = new int[50];

    void setRoot(int x) {
        t[1] = x;
    }

    void setLeft(int i, int x) {
        t[2 * i] = x;
    }

    void setRight(int i, int x) {
        t[2 * i + 1] = x;
    }

    void print() {
        for (int i = 1; i < 20; i++) {
            if (t[i] != 0)
                System.out.println(i + " -> " + t[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeArr a = new TreeArr();

        System.out.print("Enter root: ");
        a.setRoot(sc.nextInt());

        System.out.print("Enter left of root: ");
        a.setLeft(1, sc.nextInt());

        System.out.print("Enter right of root: ");
        a.setRight(1, sc.nextInt());

        System.out.print("Enter left of node 2: ");
        a.setLeft(2, sc.nextInt());

        a.print();
    }
    
}
