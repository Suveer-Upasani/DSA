package Final;
class Node{
    int data;
    Node l, r;
    Node(int data){
        this.data=data;
        l=r=null;
    }
}
public class BST {
    Node root;
    Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key<root.data){
            root.l=insert(root.l, key);
        }
        else{
            root.r=insert(root.r, key);
        }
        return root;
    }

    void inorder(Node root){
        if(root!=null){
            inorder(root.l);
            System.out.println(root.data+"");
            inorder(root.r);
        }
    }
}
