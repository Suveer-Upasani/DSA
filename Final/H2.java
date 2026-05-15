package Final;

import java.util.Scanner;

public class H2 {
    int[] table;
    int size;
    H2(int s){
        size=s;
        table=new int[size];
        for(int i=0;i<size;i++){
            table[i]=-1;
        }
    }

    int hash(int key){
        return key%size;
    } 

    void insert(int key){
        int index=hash(key);

        while(table[index]!=-1){
            index=(index+1)%size;
        }
        table[index]=key;
        System.out.println("Inserted");
    }
    
    void search(int key){
        int index=hash(key);
        int start=index;

        while (table[index]!=-1) {
            if(table[index]==key){
                System.out.println("Found");
                return;
            }
            index=(index+1)%size;

            if(index==start)break;
        }
        System.out.println("Not founda");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size");
        int s=sc.nextInt();

        H2 h=new H2(s);
        int ch;
        do{

        System.out.println("1.Insert 2.Search 3.Disply");
        ch=sc.nextInt();
        switch (ch) {
            
            case 1:
                System.out.println("Enter key:");
                int key=sc.nextInt();
                h.insert(key);
                break;
        
            case 2:
                System.out.println("Enter key:");
                int skey=sc.nextInt();
                h.search(skey);
                break;    
            default:
                break;
        }
    }while (ch!=3); 
}
}