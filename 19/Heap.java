import java.util.*;

public class Heap{
    int[] h;
    int size;

    Heap(int n){
        h=new int[n];
        size=0;
    }

    void insert(int x){
        h[size]=x;
        int i=size;
        size++;

        while(i>0 && h[(i-1)/2]>h[i]){
            int temp=h[i];
            h[i]=h[(i-1)/2];
            h[(i-1)/2]=temp;
            i=(i-1)/2;
        }
    }

    int delete(){
        int min=h[0];
        h[0]=h[size-1];
        size--;

        int i=0;

        while(true){
            
        }
    }
}