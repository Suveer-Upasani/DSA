import java.util.Scanner;
public class PrimMSTMenu {
    static void primMST(int[][] graph, int V) {
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < V - 1; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] > 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " \t" + graph[parent[i]][i]);
        }
    }

    static void display(int[][] graph, int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] graph = new int[20][20];
        int V = 0;

        while (true) {
            System.out.println("1.Input Graph");
            System.out.println("2.Display Graph");
            System.out.println("3.Prim MST");
            System.out.println("4.Exit");

            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter number of vertices: ");
                V = sc.nextInt();

                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        graph[i][j] = 0;
                    }
                }

                System.out.print("Enter number of edges: ");
                int E = sc.nextInt();

                for (int i = 0; i < E; i++) {
                    System.out.print("Enter source vertex: ");
                    int u = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int v = sc.nextInt();
                    System.out.print("Enter weight: ");
                    int w = sc.nextInt();

                    graph[u][v] = w;
                    graph[v][u] = w;
                }
            } else if (ch == 2) {
                display(graph, V);
            } else if (ch == 3) {
                primMST(graph, V);
            } else if (ch == 4) {
                break;
            }
        }
    }
}