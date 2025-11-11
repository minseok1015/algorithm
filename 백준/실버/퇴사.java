import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] counsel = new int[N+1][2];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];

        for(int i=1;i<=N;i++){
            //상담을 할 경우
            int end = counsel[i][0]+i-1;
            if(end <=N){
                dp[end+1] = Math.max(dp[i] + counsel[i][1],dp[end+1]);
            }
            //상담을 안 할 경우
            dp[i+1] = Math.max(dp[i+1],dp[i]);

            // System.out.println(i+"번째 dp 상태");
            // for(int j=1;j<=N;j++){
            //   System.out.print(dp[j]+ " ");
            // }
            // System.out.println();
        }

        int answer=0;

        for(int i=1;i<=N+1;i++){
            answer=Math.max(answer,dp[i]);
        }

        System.out.println(answer);
    }
}
