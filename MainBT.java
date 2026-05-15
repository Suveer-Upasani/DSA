import java.util.*;
class BinaryTreeArray{
    int tree[]=new int[15];
    int n;
    Scanner sc=new Scanner(System.in);
    void create(){ // O(n)
        System.out.print("Enter number of nodes: ");
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("Enter value: ");
            tree[i]=sc.nextInt();
        }
    }
    void inorderRec(int i){ // O(n)
        if(i<=n){
            inorderRec(2*i);
            System.out.print(tree[i]+" ");
            inorderRec(2*i+1);
        }
    }
    void preorderRec(int i){ // O(n)
        if(i<=n){
            System.out.print(tree[i]+" ");
            preorderRec(2*i);
            preorderRec(2*i+1);
        }
    }
    void postorderRec(int i){ // O(n)
        if(i<=n){
            postorderRec(2*i);
            postorderRec(2*i+1);
            System.out.print(tree[i]+" ");
        }
    }
    void inorderNonRec(){ // O(n)
        int stack[]=new int[100];
        int top=-1;
        int i=1;
        while(i<=n || top!=-1){
            while(i<=n){
                stack[++top]=i;
                i=2*i;
            }
            i=stack[top--];
            System.out.print(tree[i]+" ");
            i=2*i+1;
        }
    }
    void preorderNonRec(){ // O(n)
        int stack[]=new int[100];
        int top=-1;
        stack[++top]=1;
        while(top!=-1){
            int i=stack[top--];
            if(i<=n){
                System.out.print(tree[i]+" ");
                stack[++top]=2*i+1;
                stack[++top]=2*i;
            }
        }
    }
    void postorderNonRec(){ // O(n)
        int stack1[]=new int[100];
        int stack2[]=new int[100];
        int top1=-1,top2=-1;
        stack1[++top1]=1;
        while(top1!=-1){
            int i=stack1[top1--];
            if(i<=n){
                stack2[++top2]=i;
                stack1[++top1]=2*i;
                stack1[++top1]=2*i+1;
            }
        }
        while(top2!=-1)
            System.out.print(tree[stack2[top2--]]+" ");
    }
    void terminal(){ // O(n)
        int count=0;
        for(int i=1;i<=n;i++){
            if(2*i>n && 2*i+1>n)
                count++;
        }
        System.out.println("Terminal Nodes: "+count);
    }
    void display(){ // O(n)
        for(int i=1;i<=n;i++)
            System.out.print(tree[i]+" ");
    }
}
public class MainBT{
    public static void main(String[] args){ 
        Scanner sc=new Scanner(System.in);
        BinaryTreeArray bt=new BinaryTreeArray();
        int ch;
        do{
            System.out.println("\n1.Create");
            System.out.println("2.Inorder Recursive");
            System.out.println("3.Preorder Recursive");
            System.out.println("4.Postorder Recursive");
            System.out.println("5.Terminal Nodes");
            System.out.println("6.Display");
            System.out.println("7.Inorder Non Recursive");
            System.out.println("8.Preorder Non Recursive");
            System.out.println("9.Postorder Non Recursive");
            System.out.println("0.Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1: bt.create(); break;
                case 2: bt.inorderRec(1); break;
                case 3: bt.preorderRec(1); break;
                case 4: bt.postorderRec(1); break;
                case 5: bt.terminal(); break;
                case 6: bt.display(); break;
                case 7: bt.inorderNonRec(); break;
                case 8: bt.preorderNonRec(); break;
                case 9: bt.postorderNonRec(); break;
            }
        }while(ch!=0);
    }
}