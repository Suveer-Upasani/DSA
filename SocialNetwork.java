import java.util.*;

public class SocialNetwork {
    static Map<String, List<String>> graph = new HashMap<>();

    // Add user
    static void addUser(String user) {
        graph.putIfAbsent(user, new ArrayList<>());
    }

    // Add connection
    static void addConnection(String u1, String u2) {
        graph.get(u1).add(u2);
        graph.get(u2).add(u1);
    }

    // Display graph
    static void display() {
        for (String user : graph.keySet()) {
            System.out.println(user + " -> " + graph.get(user));
        }
    }

    // BFS
    static void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(start);
        visited.add(start);

        System.out.print("BFS: ");

        while (!q.isEmpty()) {
            String cur = q.poll();
            System.out.print(cur + " ");

            for (String n : graph.get(cur)) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    q.add(n);
                }
            }
        }
        System.out.println();
    }

    // DFS
    static void dfs(String start) {
        Set<String> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    static void dfsHelper(String cur, Set<String> visited) {
        visited.add(cur);
        System.out.print(cur + " ");

        for (String n : graph.get(cur)) {
            if (!visited.contains(n)) {
                dfsHelper(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1.Add User 2.Add Edge 3.Display 4.BFS 5.DFS 6.Exit");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("User: ");
                    addUser(sc.nextLine());
                    break;

                case 2:
                    System.out.print("User1: ");
                    String u1 = sc.nextLine();
                    System.out.print("User2: ");
                    String u2 = sc.nextLine();
                    addConnection(u1, u2);
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.print("Start: ");
                    bfs(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Start: ");
                    dfs(sc.nextLine());
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Wrong choice");
            }

        } while (ch != 6);
    }
}