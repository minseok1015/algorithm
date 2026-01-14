import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int hx = -1, hy = -1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j] == '*' &&
                    map[i - 1][j] == '*' &&
                    map[i + 1][j] == '*' &&
                    map[i][j - 1] == '*' &&
                    map[i][j + 1] == '*') {
                    hx = i;
                    hy = j;
                    break;
                }
            }
            if (hx != -1) break;
        }

        int leftArm = 0;
        for (int j = hy - 1; j >= 0 && map[hx][j] == '*'; j--) leftArm++;

        int rightArm = 0;
        for (int j = hy + 1; j < N && map[hx][j] == '*'; j++) rightArm++;

        int waist = 0;
        int waistEnd = hx;
        for (int i = hx + 1; i < N && map[i][hy] == '*'; i++) {
            waist++;
            waistEnd = i;
        }

        int leftLeg = 0;
        for (int i = waistEnd + 1; i < N && map[i][hy - 1] == '*'; i++) leftLeg++;

        int rightLeg = 0;
        for (int i = waistEnd + 1; i < N && map[i][hy + 1] == '*'; i++) rightLeg++;

        System.out.println((hx + 1) + " " + (hy + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
