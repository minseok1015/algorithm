import java.util.*;

class Solution {
    int solution(int[][] land) {
        int rowNum = land.length;
        int[][] dp = new int[rowNum][4];

        for(int i=0;i<4;i++){
            dp[rowNum-1][i] = land[rowNum-1][i];
        }

        for(int i=rowNum-1 ;i>0;i--){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(j==k) continue;
                    dp[i-1][k] = Math.max(dp[i-1][k],dp[i][j]+land[i-1][k]);
                }
            }
        }

        return Arrays.stream(dp[0]).max().getAsInt();
    }
}