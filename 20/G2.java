import java.util.*;
public class G2 {
    int n;
    ArrayList<Integer>[] g;
    G2(int n){
        this.n=n;
        g=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            g[i]=new ArrayList<>();
        }
    }

    void add(int a, int b){
        g[a].add(b);
        g[b].add(a);
    }

    void bfs(int s){
        boolean[] v=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();

        v[s]=true;
        q.add(s);

        while(!q.isEmpty()){
            int x=q.poll();
            System.out.println(x+"");

            for(int i:g[x]){
                if(!v[i]){
                    v[i]=true;
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

}
