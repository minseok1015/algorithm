package 문제61;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3)));
        System.out.println(Arrays.deepToString(solution(4)));
    }

    private static int[][] solution(int n) {
        int[][] snailArray = null;
        try {

            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            //오른쪽, 아래, 왼쪽, 위

            snailArray = new int[n][n];
            boolean[][] visited = new boolean[n][n];

            int x = 0;
            int y= 0;
            visited[y][x]=true;
            int direction = 0 ;

            for(int i=1;i<=n*n;i++){
                System.out.println("("+ y+ ", "+x + ")");
                snailArray[y][x] = i;
                int new_x = x + dx[direction%4];
                int new_y = y + dy[direction%4];

                if(new_x>=n || new_y>= n || new_x <0 || new_y <0 || visited[new_y][new_x]){
                    direction++;
                    new_x = x + dx[direction%4];
                    new_y = y + dy[direction%4];
                }
                x = new_x;
                y = new_y;
                visited[y][x] = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return snailArray;
    }

}