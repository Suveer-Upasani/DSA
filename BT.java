import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    Scanner sc = new Scanner(System.in);

    // 🔹 Create tree recursively
    Node create() {
        int x;
        System.out.print("Enter value (-1 for no node): ");
        x = sc.nextInt();

        if (x == -1)
            return null;

        Node newNode = new Node(x);

        System.out.println("Enter left of " + x);
        newNode.left = create();

        System.out.println("Enter right of " + x);
        newNode.right = create();

        return newNode;
    }

    // 🔹 Preorder Traversal (NLR)
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}

public class BT {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        System.out.println("Create Binary Tree:");
        bt.root = bt.create();

        System.out.print("Preorder Traversal: ");
        bt.preorder(bt.root);
    }
}