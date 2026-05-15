package 19;

public class AVL {
    class Node{
        int height, key;
        Node right, left;
        Node(int d){
            key=d;
            height=1;
        }
    }
    Node root;

    int height(Node n){
        if(n==null)return 0;
        return n.height;
    }

    int getBalance(Node n){
        if(n==null)return 0;
        return height(n.left)-height(n.right);
    }

    Node rightNode(Node y){
        Node x=y.left;
        Node T2=x.right;

        x.right=y;
        y.left=T2;

        y.height=Math.max(height(y.left), height(y.right))+1;
        x.height=Math.max(height(x.left), height(x.right))+1;

        return x;
    }

    Node  leftNode(Node x){
        Node y=x.right;
        Node T2=y.left;

        y.left=x;
        x.right=T2;

        x.height=Math.max(height(x.left), height(x.right));
        y.height=Math.max(height(y.left), height(y.right));

        return y;
    }

    Node insert(Node node, int key){
        if(node==null)
            return new Node(key);

        if(key<node.key)
            node.left=insert(node.left, key);
        else if(key>node.key)
            node.right=insert(node.right, key);

        else
            return node;
        
        node.height=1+Math.max(height(node.left), height(node.right));

        int balance=getBalance(node);

        if(balance<-1 && key> node.right.key)
            return leftNode(node);

        if(balance>1&&key>node.left.key){
            node.left=leftNode(node.left);
            return rightNode(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightNode(node.right);
            return leftNode(node);
        }
        return node;

        
    }

    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.key+"");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        AVL tree = new AVL();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);

}
}