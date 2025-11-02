import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int personHeight = i + 1;
            int leftCount = memo[i];

            int emptySlotsFound = 0;

            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {
                    if (emptySlotsFound == leftCount) {
                        result[j] = personHeight;
                        break;
                    }
                    emptySlotsFound++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}