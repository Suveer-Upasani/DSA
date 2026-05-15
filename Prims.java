import java.util.*;

class Edge {
    int node, weight;

    Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Prims {
    int n;
    ArrayList<Edge>[] g;

    Prims(int n) {
        this.n = n;
        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new ArrayList<>();
    }

    void add(int u, int v, int w) {
        g[u].add(new Edge(v, w));
        g[v].add(new Edge(u, w));
    }

    void prim(int start) {
        boolean[] vis = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            Comparator.comparingInt(e -> e.weight)
        );

        pq.add(new Edge(start, 0));
        int cost = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (vis[cur.node]) continue;

            vis[cur.node] = true;
            cost += cur.weight;

            for (Edge e : g[cur.node])
                if (!vis[e.node])
                    pq.add(e);
        }

        System.out.println("MST Cost = " + cost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt(); // number of edges

        Prims g = new Prims(n);

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.add(u, v, w);
        }

        g.prim(1); // start from node 1
    }
}