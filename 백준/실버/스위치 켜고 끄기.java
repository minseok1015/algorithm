import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sw = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int k = num; k <= N; k += num) {
                    sw[k] = 1 - sw[k];
                }
            } else {
                int left = num;
                int right = num;
                while (left - 1 >= 1 && right + 1 <= N && sw[left - 1] == sw[right + 1]) {
                    left--;
                    right++;
                }
                for (int k = left; k <= right; k++) {
                    sw[k] = 1 - sw[k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(sw[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}
