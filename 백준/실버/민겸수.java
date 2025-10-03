import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(findMaxValue(input));
        System.out.println(findMinValue(input));
    }

    public static String findMaxValue(String s) {
        StringBuilder sb = new StringBuilder();
        int mCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'M') {
                mCount++;
            } else { // c == 'K'
                sb.append('5');
                for (int i = 0; i < mCount; i++) {
                    sb.append('0');
                }
                mCount = 0;
            }
        }

        if (mCount > 0) {
            for (int i = 0; i < mCount; i++) {
                sb.append('1');
            }
        }
        return sb.toString();
    }

    public static String findMinValue(String s) {
        StringBuilder sb = new StringBuilder();
        int mCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'M') {
                mCount++;
            } else { // c == 'K'
                if (mCount > 0) {
                    sb.append('1');
                    for (int i = 0; i < mCount - 1; i++) {
                        sb.append('0');
                    }
                }
                sb.append('5');
                mCount = 0;
            }
        }

        if (mCount > 0) {
            sb.append('1');
            for (int i = 0; i < mCount - 1; i++) {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}