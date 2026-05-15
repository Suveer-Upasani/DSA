package Testty;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge{
    int weight, node;
    Edge(int weight, int node){
        this.node=node;
        this.weight=weight;
    }
}

public class Prims {
    int n;
    ArrayList<Edge>[] g;
    Prims(int n){
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
            Edge x=pq.poll();

            if(vis[x.node])continue;

            vis[x.node]=true;
            cost+=x.weight;

            for(Edge e:g[x.node])
                if(!vis[e.node])
                    pq.add(e);
        }
        System.out.println(cost);
    }
}
