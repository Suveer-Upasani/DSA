import java.util.*;

class Edge{
    int node, weight;
    Edge(int node, int weight){
        this.weight=weight;
        this.node=node;
    }
}

public class PT {
    int n;
    ArrayList<Edge>[] g;

    PT(int n){
        this.n=n;
        g=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            g[i]=new ArrayList<>();
        }
    }

    void add(int u, int v, int w){
        g[u].add(new Edge(v, w));
        g[v].add(new Edge(u, w));
    }

    void prim(int s){
        boolean[] vis=new boolean[n+1];

        PriorityQueue<Edge> pq=new PriorityQueue<>();

        pq.add(new Edge(s, 0));
        int cost=0;

        while(!pq.isEmpty()){

            Edge cur=pq.poll();
            if(vis[cur.node])continue;

            vis[cur.node]=true;
            cost+=cur.weight;

            for(Edge e:g[cur.node])
                if(!vis[e.node])
                    pq.add(e);
        }
        System.out.println(cost);
    }
}
