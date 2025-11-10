import java.util.*;

class Solution {
    private static int INF = Integer.MAX_VALUE;

    public int solution(int[][] info, int n, int m) {
        int size = info.length;

        int[][] dp = new int[size + 1][m];

        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= size; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for (int j = 0; j < m; j++) {
                // 1. i번째 물건을 A가 훔치는 경우
                if (dp[i-1][j] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                }
                // 2. i번째 물건을 B가 훔치는 경우
                if (j + b < m && dp[i-1][j] != INF) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }
        }

        int min = INF;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[size][j]);
        }

        return min >= n ? -1 : min;
    }
}