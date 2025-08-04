import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        int[] dp = new int[K+1];


        coins[0]=0;
        for(int i=1;i<=N;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        // Arrays.sort(coins);

        dp[0]=1; //금액 0원을 만드는 가짓 수는 1가지


        //먼저 k원을 만들기 위한 이용한 최소 동전의 갯수를 구함(거스름돈 문제 응용)
        for(int i=1;i<=N;i++){  //i번째의 동전을 가지고 몇개를 만들까
            for(int j=coins[i]; j<=K;j++ ){  //j는 i번째 동전의 크기보다는 값이 커야됨(j원을 i번째의 동전을 만들 수 있을 까에 대한 반복문임)
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        System.out.println(dp[K]);


    }
}
