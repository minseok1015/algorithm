import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (dp[answer] < dp[i]) {
                answer = i;
            }
        }

        System.out.println(dp[answer]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(numbers[answer]);
        int len = dp[answer] - 1;
        int curr = numbers[answer];
        for (int i = answer - 1; i >= 0; i--) {
            if (dp[i] == len && numbers[i] < curr) {
                list.add(numbers[i]);
                curr = numbers[i];
                len--;
            }
        }

        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
