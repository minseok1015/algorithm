import java.util.*;
import java.io.*;


class Main {

    private static ArrayList<Integer>[] adjList;
    private static int[] cost;
    private static int[][] dp;

    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        cost = new int[N+1];
        dp = new int[N+1][2];

        for(int i=1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=2;i<=N;i++){
            adjList[i].add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);

        System.out.println(Math.max(dp[1][0],dp[1][1]));

    }


    private static void dfs(int now, int parent){
        int max = 0;
        for(int next : adjList[now]){
            if(next!=parent){
                dfs(next,now);
                dp[now][0] += dp[next][0];
                dp[now][1] += dp[next][0];
                max = Math.max(max,Math.abs(dp[next][0]-dp[next][1]));
            }
        }

        dp[now][0] +=max;
        dp[now][1] +=cost[now] * cost[next];
    }
}
