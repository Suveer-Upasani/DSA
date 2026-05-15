import java.util.Scanner;

class PrimMST {
    static int n;
    static int[][] cost;
    static boolean[] visited;

    static void prim() {
        int mincost = 0;
        visited[1] = true;

        for (int k = 1; k < n; k++) {
            int min = 999, u = -1, v = -1;

            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    for (int j = 1; j <= n; j++) {
                        if (!visited[j] && cost[i][j] < min) {
                            min = cost[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            if (u != -1 && v != -1) {
                System.out.println(u + " - " + v + " = " + cost[u][v]);
                mincost += cost[u][v];
                visited[v] = true;
            }
        }
        System.out.println("Total cost: " + mincost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1.Create Graph");
            System.out.println("2.Find MST using Prim");
            System.out.println("3.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter number of vertices:");
                    n = sc.nextInt();
                    cost = new int[n + 1][n + 1];
                    visited = new boolean[n + 1];

                    System.out.println("Enter adjacency matrix:");
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            cost[i][j] = sc.nextInt();
                            if (cost[i][j] == 0)
                                cost[i][j] = 999;
                        }
                    }
                    break;

                case 2:
                    for (int i = 1; i <= n; i++)
                        visited[i] = false;
                    prim();
                    break;

                case 3:
                    System.out.println("Exit");
                    break;
            }
        } while (choice != 3);

        sc.close();
    }
}