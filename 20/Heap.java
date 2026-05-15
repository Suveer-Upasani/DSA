package 20;

public class Heap {
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

        while(i<0 && h[(i-1)/2]>h[i]){
            int temp[i];
            h[i]=h
        }
    }
}
