import java.util.*;

class Edge {
    int to, weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Graph {
    int n;
    ArrayList<Edge>[] g;

    Graph(int n) {
        this.n = n;
        g = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    // Add weighted edge
    void add(int a, int b, int w) {
        g[a].add(new Edge(b, w));
        g[b].add(new Edge(a, w));
    }

    // Prim's Algorithm
    void primMST(int start) {
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (a, b) -> a.weight - b.weight
        );

        pq.add(new Edge(start, 0));

        int totalCost = 0;

        System.out.println("Edges in MST:");

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            if (visited[u]) continue;

            visited[u] = true;
            totalCost += current.weight;

            System.out.println("Node: " + u + " Weight: " + current.weight);

            for (Edge e : g[u]) {
                if (!visited[e.to]) {
                    pq.add(e);
                }
            }
        }

        System.out.println("Total Cost of MST: " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        Graph graph = new Graph(n);

        int ch;
        do {
            System.out.println("\n1. Insert Edge\n2. Prim's MST\n3. Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter node1 node2 weight:");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int w = sc.nextInt();
                    graph.add(a, b, w);
                    break;

                case 2:
                    System.out.println("Enter starting node:");
                    int s = sc.nextInt();
                    graph.primMST(s);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (ch != 3);
    }
}