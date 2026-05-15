package 21;

class Node{
    int d;
    Node l, r;

    Node(int x){
        int d=x;
    }
}
public class BST {
    Node root;
    void insert(int x){
        Node n=new Node(x);

        if(root==null){
            root=n;
            return;
        }
        Node cur=root;
        
        while(true){
            if(x<cur.d){
                if(cur.l==null){
                    cur.l=n;
                    break;
                }
                cur=cur.l;
            }
            else{
                if(cur.r==null){
                    cur.r=n;
                    break;
                }
                cur=cur.r;
            }
        }
    }
}
