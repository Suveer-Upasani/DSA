import java.util.*;

public class Graph {
    int n;
    ArrayList<Integer>[] g;

    @SuppressWarnings("unchecked")
    Graph(int n) {
        this.n = n;
        g = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    void add(int a, int b) {
        // ✅ SIMPLE SAFETY CHECK
        if (a > n || b > n || a <= 0 || b <= 0) {
            System.out.println("Invalid edge! Use nodes from 1 to " + n);
            return;
        }

        g[a].add(b);
        g[b].add(a);
    }

    void bfs(int s) {
        boolean[] v = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        v[s] = true;
        q.add(s);

        System.out.println("BFS:");

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int i : g[x]) {
                if (!v[i]) {
                    v[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

    void dfs(int s) {
        boolean[] v = new boolean[n + 1];
        System.out.println("DFS:");
        dfsRec(s, v);
        System.out.println();
    }

    void dfsRec(int s, boolean[] v) {
        v[s] = true;
        System.out.print(s + " ");

        for (int i : g[s]) {
            if (!v[i]) {
                dfsRec(i, v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        Graph obj = new Graph(n);

        while (true) {
            System.out.println("\n1.Add  2.BFS  3.DFS  4.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter a b:");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    obj.add(a, b);
                    break;

                case 2:
                    System.out.println("Start:");
                    obj.bfs(sc.nextInt());
                    break;

                case 3:
                    System.out.println("Start:");
                    obj.dfs(sc.nextInt());
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}