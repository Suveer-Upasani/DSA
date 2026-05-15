import java.util.*;
class AVLNode{
    int key,height;
    AVLNode left,right,parent;
    AVLNode(int k){ // Time Complexity: O(1)
        key=k;
        height=1;
    }
}
class AVLTree{
    AVLNode root;
    int height(AVLNode n){ // Time Complexity: O(1)
        if(n==null) return 0;
        return n.height;
    }
    int max(int a,int b){ // Time Complexity: O(1)
        return (a>b)?a:b;
    }
    AVLNode rightRotate(AVLNode y){ // Time Complexity: O(1)
        AVLNode x=y.left;
        AVLNode t2=x.right;
        x.right=y;
        y.left=t2;
        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;
        return x;
    }
    AVLNode leftRotate(AVLNode x){ // Time Complexity: O(1)
        AVLNode y=x.right;
        AVLNode t2=y.left;
        y.left=x;
        x.right=t2;
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        return y;
    }
    int balance(AVLNode n){ // Time Complexity: O(1)
        if(n==null) return 0;
        return height(n.left)-height(n.right);
    }
    AVLNode insert(AVLNode node,int key){ // Time Complexity: O(log n)
        if(node==null) return new AVLNode(key);
        if(key<node.key) node.left=insert(node.left,key);
        else node.right=insert(node.right,key);
        node.height=1+max(height(node.left),height(node.right));
        int balance=balance(node);

        if(balance>1 && key<node.left.key) return rightRotate(node);

        if(balance<-1 && key>node.right.key) return leftRotate(node);

        if(balance>1 && key>node.left.key){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance<-1 && key<node.right.key){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    AVLNode minValueNode(AVLNode node){ // Time Complexity: O(log n)
        AVLNode current=node;
        while(current.left!=null)
            current=current.left;

        return current;
    }
    AVLNode delete(AVLNode root,int key){ // Time Complexity: O(log n)
        if(root==null) return root;

        if(key<root.key) root.left=delete(root.left,key);
        else if(key>root.key) root.right=delete(root.right,key);

        else{
            if((root.left==null)||(root.right==null)){
                AVLNode temp=null;

                if(temp==root.left) temp=root.right;
                else temp=root.left;

                if(temp==null){
                    temp=root;
                    root=null;
                }
                else root=temp;
            }
            else{
                AVLNode temp=minValueNode(root.right);
                root.key=temp.key;
                root.right=delete(root.right,temp.key);
            }
        }

        if(root==null) return root;

        root.height=max(height(root.left),height(root.right))+1;

        int balance=balance(root);

        if(balance>1 && balance(root.left)>=0)
            return rightRotate(root);

        if(balance>1 && balance(root.left)<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }

        if(balance<-1 && balance(root.right)<=0)
            return leftRotate(root);

        if(balance<-1 && balance(root.right)>0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void inorder(AVLNode root){ // Time Complexity: O(n)
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }

    void preorder(AVLNode root){ // Time Complexity: O(n)
        if(root!=null){
            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(AVLNode root){ // Time Complexity: O(n)
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ");
        }
    }
}
public class Main{
    public static void main(String args[]){ 
        Scanner sc=new Scanner(System.in);
        AVLTree t=new AVLTree();
        int ch,x;
        do{
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Inorder");
            System.out.println("4.Preorder");
            System.out.println("5.Postorder");
            System.out.println("0.Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter key:");
                    x=sc.nextInt();
                    t.root=t.insert(t.root,x);
                    break;
                case 2:
                    System.out.print("Enter key:");
                    x=sc.nextInt();
                    t.root=t.delete(t.root,x);
                    break;
                case 3:
                    t.inorder(t.root);
                    System.out.println();
                    break;
                case 4:
                    t.preorder(t.root);
                    System.out.println();
                    break;
                case 5:
                    t.postorder(t.root);
                    System.out.println();
                    break;
            }
        }while(ch!=0);
    }
}