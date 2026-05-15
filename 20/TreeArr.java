import java.util.*;
public class TreeArr {
    int t[]=new int[50];

    void setRoot(int x){
        t[1]=x;
    }

    void setLeft(int i, int x){
        t[2*1]=x;
    }

    void setRight(int i, int x){
        t[2*i+1]=x;
    }

    void print(){
        for(int i=1;i<20;i++){
            if(t[i]!=0){
                System.out.println(i+"->"+t[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeArr a=new TreeArr();

        System.out.println("Enter Root:");
        a.setRoot(sc.nextInt());

        
    }
}
