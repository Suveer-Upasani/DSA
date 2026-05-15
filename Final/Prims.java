package Final;
import java.util.*;
class Edge{
    int node, weight;
    Edge(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}
public class Prims {
    int n;
    ArrayList<Edge>[] g;
    @SuppressWarnings("unchecked")

    Prims(int n){
        this.n=n;
        g = (ArrayList<Edge>[]) new ArrayList[n + 1];
        for(int i=0;i<=n;i++){
            g[i]=new ArrayList<>();
        }
    }

    void add(int u, int v, int w){
        g[u].add(new Edge(v, w));
        g[v].add(new Edge(u, w));
    }
    
    void prim(int s){
        boolean[] vis = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    
        pq.add(new Edge(s, 0));
    
        int cost = 0;
    
        while(!pq.isEmpty()){
            Edge x = pq.poll();
    
            if(vis[x.node]) continue;
    
            vis[x.node] = true;
            cost += x.weight;
        
            for(Edge e : g[x.node]){
                if(!vis[e.node]){
                    pq.add(e);
                }
            }
        }
        System.out.println("Total cost = " + cost);
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
    
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
    
        Prims g = new Prims(n);
    
        System.out.println("Enter edges (u v weight):");
    
        for(int i = 0; i < e; i++){
            System.out.print("Edge " + (i+1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
    
            g.add(u, v, w);
        }
        System.out.println("\nRunning Prim's Algorithm...\n");
        g.prim(1);
    }
}
