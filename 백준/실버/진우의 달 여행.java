import java.io.
import java.util.*

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];

        int INF = 1000000;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                Arrays.fill(dp[r][c], INF);
            }
        }

        for (int c = 0; c < M; c++) {
            dp[0][c][0] = cost[0][c];
            dp[0][c][1] = cost[0][c];
            dp[0][c][2] = cost[0][c];
        }

        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (c > 0) {
                    dp[r][c][0] = cost[r][c] + Math.min(dp[r - 1][c - 1][1], dp[r - 1][c - 1][2]);
                }

                dp[r][c][1] = cost[r][c] + Math.min(dp[r - 1][c][0], dp[r - 1][c][2]);

                if (c < M - 1) {
                    dp[r][c][2] = cost[r][c] + Math.min(dp[r - 1][c + 1][0], dp[r - 1][c + 1][1]);
                }
            }
        }

        int minFuel = INF;
        for (int c = 0; c < M; c++) {
            for (int dir = 0; dir < 3; dir++) {
                minFuel = Math.min(minFuel, dp[N - 1][c][dir]);
            }
        }

        System.out.println(minFuel);
    }
}