import java.util.*;

public class Graph {

    int n;
    ArrayList<Integer>[] g;

    Graph(int n) {
        this.n = n;
        g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    void add(int a, int b) {
        g[a].add(b);
        g[b].add(a);
    }

    void bfs(int s) {
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        v[s] = true;
        q.add(s);

        System.out.print("BFS: ");

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
        boolean[] v = new boolean[n];
        System.out.print("DFS: ");
        dfsRec(s, v);
        System.out.println();
    }

    void dfsRec(int s, boolean[] v) {
        v[s] = true;
        System.out.print(s + " ");

        for (int i : g[s]) {
            if (!v[i])
                dfsRec(i, v);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nodes: ");
        int n = sc.nextInt();

        Graph obj = new Graph(n);

        int ch;

        do {
            System.out.println("\n1.Add Edge");
            System.out.println("2.BFS");
            System.out.println("3.DFS");
            System.out.println("4.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter a b: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    obj.add(a, b);
                    break;

                case 2:
                    System.out.print("Start: ");
                    obj.bfs(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Start: ");
                    obj.dfs(sc.nextInt());
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (ch != 4);

        sc.close();
    }
}