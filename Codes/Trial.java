public class Trial {
    class Node{
        int key, height;
        Node right, left;
        Node(int d){
            key=d;
            height=-1;
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
        x.height=Math.max(height(x.left), height(x.left))+1;

        return x;
    }

    Node leftNode(Node x){
        Node y=x.right;
        Node T2=x.left;

        x.left=x;
        y.right=T2;

        y.height=Math.max(height(x.left), height(x.right))+1;
        x.height=Math.max(height(y.left), height(y.right))+1;

        return y;
    }

    Node insert(Node node, int key){
        if(node==null)
            return new Node(key);
    }
}
