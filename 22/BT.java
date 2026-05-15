import java.util.*;

class Node{
    int data;
    Node left, right;

    Node(int x){
        data=x;
        left=right=null;
    }
}

class BT{
    Node root;
    Scanner sc=new Scanner(System.in);

    Node insert(){
        int x;
        System.out.println("Enter node value");
        x=sc.nextInt();

        if(x==-1)
            return null;

        Node newNode=new Node(x);

        System.out.println("Enter left of"+x);
        newNode.left=insert();

        System.out.println("Enter right"+x);
        newNode.right=insert();

        return newNode;
    }

    void preorder(Node root){
        if(root!=null){
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
        BT b=new BT();
        System.out.println("Create Binary tree:");
        b.root=b.insert();

        System.out.println("preorder:");
        b.preorder((b.root));
    }
}