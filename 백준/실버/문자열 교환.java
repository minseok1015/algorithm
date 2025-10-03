import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int a_count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                a_count++;
            }
        }

        if (a_count == 0) {
            System.out.println(0);
            return;
        }

        int min = Integer.MAX_VALUE;

        String temp = s + s;

        int window = 0;
        for (int i = 0; i < a_count; i++) {
            if (temp.charAt(i) == 'b') {
                window++;
            }
        }
        min = window;

        for (int i = 1; i < n; i++) {
            if (temp.charAt(i - 1) == 'b') {
                window--;
            }
            if (temp.charAt(i + a_count - 1) == 'b') {
                window++;
            }

            min = Math.min(min, window);
        }

        System.out.println(min);
    }
}