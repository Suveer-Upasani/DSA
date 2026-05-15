import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){ // O(1)
        data=d;
        left=right=null;
    }
}
class BST{
    Node root;
    void insert(int key){ // O(log n) avg, O(n) worst
        Node newNode=new Node(key);
        if(root==null){
            root=newNode;
            return;
        }
        Node parent=null,current=root;
        while(current!=null){
            parent=current;
            if(key<current.data) current=current.left;
            else current=current.right;
        }
        if(key<parent.data) parent.left=newNode;
        else parent.right=newNode;
    }
    void search(int key){ // O(log n) avg, O(n) worst
        Node temp=root;
        while(temp!=null){
            if(temp.data==key){
                System.out.println("Found");
                return;
            }
            if(key<temp.data) temp=temp.left;
            else temp=temp.right;
        }
        System.out.println("Not Found");
    }
    void findMin(){ // O(log n) avg, O(n) worst
        if(root==null){
            System.out.println("Tree Empty");
            return;
        }
        Node temp=root;
        while(temp.left!=null) temp=temp.left;
        System.out.println("Min = "+temp.data);
    }
    void findMax(){ // O(log n) avg, O(n) worst
        if(root==null){
            System.out.println("Tree Empty");
            return;
        }
        Node temp=root;
        while(temp.right!=null) temp=temp.right;
        System.out.println("Max = "+temp.data);
    }
    Node delete(Node root,int key){ // O(log n) avg, O(n) worst
        if(root==null) return root;
        if(key<root.data) root.left=delete(root.left,key);
        else if(key>root.data) root.right=delete(root.right,key);
        else{
            if(root.left==null && root.right==null) return null;
            else if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            Node temp=root.right;
            while(temp.left!=null) temp=temp.left;
            root.data=temp.data;
            root.right=delete(root.right,temp.data);
        }
        return root;
    }
    void deleteKey(int key){ // O(log n) avg, O(n) worst
        root=delete(root,key);
    }
    void inorder(Node root){ // O(n)
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    void preorder(Node root){ // O(n)
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void postorder(Node root){ // O(n)
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }
    void displayIn(){ // O(n)
        if(root==null){System.out.println("Tree Empty");return;}
        inorder(root);
        System.out.println();
    }
    void displayPre(){ // O(n)
        if(root==null){System.out.println("Tree Empty");return;}
        preorder(root);
        System.out.println();
    }
    void displayPost(){ // O(n)
        if(root==null){System.out.println("Tree Empty");return;}
        postorder(root);
        System.out.println();
    }
}
public class MainBST{
    public static void main(String[] args){ // depends on operations
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        int ch,x;
        do{
            System.out.println("\n1.Insert");
            System.out.println("2.Search");
            System.out.println("3.Find Min");
            System.out.println("4.Find Max");
            System.out.println("5.Inorder");
            System.out.println("6.Preorder");
            System.out.println("7.Postorder");
            System.out.println("8.Delete");
            System.out.println("0.Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1: x=sc.nextInt(); bst.insert(x); break;
                case 2: x=sc.nextInt(); bst.search(x); break;
                case 3: bst.findMin(); break;
                case 4: bst.findMax(); break;
                case 5: bst.displayIn(); break;
                case 6: bst.displayPre(); break;
                case 7: bst.displayPost(); break;
                case 8: x=sc.nextInt(); bst.deleteKey(x); break;
            }
        }while(ch!=0);
    }
}