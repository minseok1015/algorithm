//https://www.acmicpc.net/problem/2178

import java.util.*;
import java.io.*;

class Main {

    private static int[][] map;
    private static int[][] visited;
    private static int N;
    private static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열

        map = new int[N][M];

        for(int i =0 ; i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new int[N][M];

        bfs();

        System.out.println(visited[N-1][M-1]);

    }

    private static void bfs(){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        visited[0][0]=1;

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i =0 ; i<4;i++){
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if(newX<0 || newY<0 || newX>=M || newY>=N){
                    continue;
                }

                if(map[newY][newX]==0){
                    continue;
                }

                if(visited[newY][newX]==0){
                    queue.add(new Node(newX,newY));
                    visited[newY][newX] = visited[now.y][now.x]+1;
                }
            }

        }

    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
