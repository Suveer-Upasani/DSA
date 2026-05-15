import java.util.*;
public class G3 {
    int n;
    ArrayList<Integer>[] g;

    G3(int n){
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

    void dfs(int s){
        boolean[] v=new boolean[n+1];
        dfsRec(s, v);
        System.out.println();
    }

    void dfsRec(int s, boolean[] v){
        v[s]=true;
        System.out.println(s+"");

        for(int i:g[s]){
            if(!v[i]){
                dfsRec(i, v);
            }
        }
    }
}
