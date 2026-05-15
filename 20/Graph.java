import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

package 20;

public class Graph {
    int n;
    ArrayList<Integer>[] g;

    Graph(int n){
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
            for(int i:g[x]){
                v[i]=true;
                q.add(i);
            }
        }
        System.out.println();
    }

    void dfs(int s, boolean[] v){
        v[s]=true;
        for(int i:g[s]){
            if(!v[i])
                dfs(i, v);
        }
    }
    
}
