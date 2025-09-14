import java.util.*;
import java.io.*;


class Main {

    private static boolean[] visited;
    private static int[] city;
    private static int[][] dp;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        city = new int[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            city[i] = Integer.parseInt(st.nextToken());
        }


        adjList = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited[1]=true;
        dfs(1);

        System.out.println(Math.max(dp[1][0],dp[1][1]));


    }

    private static void dfs(int now){

        for(int next : adjList[now]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
                dp[now][0] += Math.max(dp[next][1],dp[next][0]);
                dp[now][1] += dp[next][0];
            }
        }

        dp[now][1] += city[now];

    }
}


/**
 1. '우수 마을'로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
 2. 즉 '우수 마을'끼리는 서로 인접해 있을 수 없다.
 3. '우수 마을'로 선정되지 못한 마을은 적어도 하나의 '우수 마을'과는 인접해 있어야 한다.
 **/