
public class Hash {
    int[] table;
    int size;

   Hash(int s){
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

        while(table[index]!=-1){
            if(table[index]==key){
                System.out.println("Found");
                return;
            }
            index=(index+1)%size;

            if(index==start)break;
        }
        System.out.println("Not found");
    }
}
