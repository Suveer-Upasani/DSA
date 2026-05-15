
public class BST {
    public class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    Node root;
    Node insert(Node node, int data){
        if(node==null){
            System.out.println("Node inserted");
            return new Node(data);
        }
        if(data<node.data){
            node.left=insert(node.left, data);
        }
        else if(data>node.data){
            node.right=insert(node.right, data);
        }
        return node;
    }
    
}
