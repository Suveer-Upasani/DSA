import java.util.*;


public class G1 {
    int n;
    ArrayList<Integer>[] g;

    G1(int n){
        this.n=n;
        g=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            g[i]=new ArrayList<>();
        }
    }

    void add(int a, int b){
        g[a].add(b);
        g[b].add(a);
    }

    void bfs(int s){
        boolean[] v=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();

        v[s]=true;
        q.add(s);

        while(!q.isEmpty()){
            int x=q.poll();
            System.out.print(x + " ");
            for(int i: g[x]){
                if (!v[i]) {
                    v[i]=true;
                    q.add(i);
            }
            }
        }
        System.out.println();
    }
    void dfs(int s, boolean[] v){
        v[s]=true;
        for(int i:g[s]){
            if(!v[i]){
                dfs(i, v);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Nodes:");
        int n=sc.nextInt();

        G1 g=new G1(n);

        int ch;
        do{
            System.out.println("1.Insert 2.BFS 3.DFS");
            ch=sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter A and B:");
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    g.add(a, b);
                    break;
                case 2:
                    System.out.print("Start:");
                    g.bfs(sc.nextInt())    ;
                    break;
            
                case 3:
                    System.out.println("Start:");
                    int start = sc.nextInt();
                    boolean[] v = new boolean[n + 1];
                    g.dfs(start, v);
                    System.out.println();
                    break;

                default:
                    break;
            }
        }while(ch!=4);
        
}}
