import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[500001];
        int[] dp = new int[500001];

        Arrays.fill(nums,-1);
        Arrays.fill(dp,1);

        int max_a = 0;

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nums[a] = b;
            max_a = Math.max(max_a,a);
        }


        int max = 0;
        for(int i=1;i<=max_a;i++){
            for(int j=1;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
            // System.out.println("dp[" + i+"] : " + dp[i]);
        }
        System.out.println(n-max);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = max_a; i>0;i--){
            if(nums[i]==-1){
                // System.out.println("continue(없는 수) : " + i);
                continue;
            }

            if(dp[i]==max){
                max--;
                // System.out.println("continue(순서) : " + i);
                continue;
            }


            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
