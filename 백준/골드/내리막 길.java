import java.util.*;
import java.io.*;


class Main {
    private static int[][] map;
    private static int[][] dp;

    private static int[] dn = {0,0,-1,1};
    private static int[] dm = {-1,1,0,0};
    private static int answer = 0;

    private static int N;
    private static int M;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];


        for(int i=0;i<M;i++){
            Arrays.fill(dp[i],-1);
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(back(0,0));

    }


    private static int back(int n,int m){
        if(n==M-1&&m==N-1){
            return 1;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }


        dp[n][m]=0;
        for(int i=0;i<4;i++){
            int new_n = n+dn[i];
            int new_m = m+dm[i];

            if(new_n<0||new_n>=M||new_m<0||new_m>=N){
                continue;
            }

            if(map[new_n][new_m]<map[n][m]){
                dp[n][m] += back(new_n,new_m);
            }
        }

        return dp[n][m];

    }

}
