import java.util.*;
import java.io.*;


class Main {
    private static boolean[] visited;
    private static ArrayList<Node>[] adjList;
    private static int node;
    private static int max;

    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        adjList = new ArrayList[V+1];

        for(int i=1;i<=V;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int v= Integer.parseInt(st.nextToken());

            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                int b = Integer.parseInt(st.nextToken());
                adjList[v].add(new Node(a, b));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    private static void dfs(int n, int len){
        if(len>max){
            max =len;
            node=n;
        }
        visited[n]=true;

        for(Node node : adjList[n]){
            if(!visited[node.edge]){
                dfs(node.edge,node.cost+len);
                // visited[node.edge]=true;
            }
        }
    }

    private static class Node{
        int edge;
        int cost;

        public Node(int e,int c){
            this.edge=e;
            this.cost=c;
        }
    }
}
