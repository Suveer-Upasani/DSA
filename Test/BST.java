import java.util.Scanner;

class Node {
    int d;
    Node l, r;

    Node(int x) {
        d = x;
    }
}

class BST {
    Node root;

    // Non-recursive insert
    void insert(int x) {
        Node n = new Node(x);

        if (root == null) {
            root = n;
            return;
        }

        Node cur = root;

        while (true) {
            if (x < cur.d) {
                if (cur.l == null) {
                    cur.l = n;
                    break;
                }
                cur = cur.l;
            } else {
                if (cur.r == null) {
                    cur.r = n;
                    break;
                }
                cur = cur.r;
            }
        }
    }

    // ✅ Recursive Inorder
    void inorder(Node r) {
        if (r != null) {
            inorder(r.l);
            System.out.print(r.d + " ");
            inorder(r.r);
        }
    }

    // ✅ Recursive Preorder
    void preorder(Node r) {
        if (r != null) {
            System.out.print(r.d + " ");
            preorder(r.l);
            preorder(r.r);
        }
    }

    // ✅ Recursive Postorder
    void postorder(Node r) {
        if (r != null) {
            postorder(r.l);
            postorder(r.r);
            System.out.print(r.d + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST b = new BST();

        int ch, x;

        do {
            System.out.println("\n1 Insert\n2 Inorder\n3 Preorder\n4 Postorder\n0 Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    x = sc.nextInt();
                    b.insert(x);
                    break;

                case 2:
                    System.out.print("Inorder: ");
                    b.inorder(b.root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Preorder: ");
                    b.preorder(b.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Postorder: ");
                    b.postorder(b.root);
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (ch != 0);
    }
}