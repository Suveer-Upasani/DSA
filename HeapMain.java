import java.util.*;
class Heap{
    int heap[]=new int[15];
    int size=0;
    void insert(int x){ // O(log n)
        size++;
        heap[size]=x;
        int i=size;
        while(i>1 && heap[i]>heap[i/2]){
            int temp=heap[i];
            heap[i]=heap[i/2];
            heap[i/2]=temp;
            i=i/2;
        }
    }
    int delete(){ // O(log n)
        int max=heap[1];
        heap[1]=heap[size];
        size--;
        int i=1;
        while(i*2<=size){
            int child=i*2;
            if(child+1<=size && heap[child+1]>heap[child]) child++;
            if(heap[i]<heap[child]){
                int temp=heap[i];
                heap[i]=heap[child];
                heap[child]=temp;
                i=child;
            }else break;
        }
        return max;
    }
    void heapSort(){ // O(n log n)
        int temp=size;
        while(size>0) System.out.print(delete()+" ");
        size=temp;
        System.out.println();
    }
    void display(){ // O(n)
        for(int i=1;i<=size;i++) System.out.print(heap[i]+" ");
        System.out.println();
    }
}
public class HeapMain{
    public static void main(String args[]){ 
        Scanner sc=new Scanner(System.in);
        Heap h=new Heap();
        int ch,x;
        do{
            System.out.println("1.Insert");
            System.out.println("2.Heap Sort");
            System.out.println("3.Display");
            System.out.println("0.Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter element:");
                    x=sc.nextInt();
                    h.insert(x);
                    break;
                case 2:
                    h.heapSort();
                    break;
                case 3:
                    h.display();
                    break;
            }
        }while(ch!=0);
    }
}