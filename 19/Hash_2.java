import java.util.Scanner;

package 19;

public class Hash_2 {
    int[] table;
    int size;
    Hash_2(int s){
        size=s;
        for(int i;i<size;i++){
            table=new int[size];
        }
    }
    
    int hash(int key){
        return key%size;
    }

    void insert(int key){
        int index=hash(key);

        while(table[index]!=1){
            index=(index+1)%size;
        }
        table[index]=key;
        System.out.println("Inserted");
    }

    void search(int key){
        int index=hash(key);
        int start=index;

        while(table[index]!=1){
            if(table[index]==key){
                System.out.println("Found");
                return;
            }
            index=(index+1)%size;

        if(index==start)break;
        }
        System.out.println("Not Found");
    }

    void display(){
        for(int i=0;i<size;i++){
            System.out.println(i+"->"+table[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Sizez:");
        int n=sc.nextInt();

        HashTable h=new HashTable(n);
        int ch, key;

        do{
            System.out.println("Insert 2.search 3.Display");
            switch (ch) {
                case 1:
                    key=sc.nextInt();
                    h.insert(key);
                    break;
                case 2:
                    key=sc.nextInt();
                    h.search(key);
                    break;

                case 3:
                    h.display();
                    break;    
                default:
                    break;
            }
        }
        while (ch!=4); 
    }
}
