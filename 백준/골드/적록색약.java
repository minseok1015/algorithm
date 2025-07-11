//https://www.acmicpc.net/problem/10026

import java.io.*;
import java.util.*;

class Main {
    private static char[][] map;
    private static int N;
    private static boolean[][] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j);
            }
        }


        int[] dRow = {-1,1,0,0};
        int[] dCol = {0,0,-1,1};
        ArrayDeque<Node> queue = new ArrayDeque<>();

        int count1 = 0;

        Node start;
        while((start = findNotVisited()) != null){
            queue.add(start);
            visited[start.row][start.col] = true;

            while(!queue.isEmpty()){
                Node now = queue.poll();


                // System.out.println("now_row: " + now.row + ", now_col :" + now.col);

                // visited[now.row][now.col]=true;

                for(int i=0;i<4;i++){
                    int new_row= now.row+dRow[i];
                    int new_col= now.col+dCol[i];
                    // System.out.println("new_row: " + new_row + ", new_col :" + new_col);

                    //범위 확인
                    if(new_row<0||new_col<0||new_row>=N||new_col>=N){
                        continue;
                    }

                    //이미 방문했는지 확인
                    if(visited[new_row][new_col]){
                        continue;
                    }

                    if(map[now.row][now.col]==map[new_row][new_col]){
                        // System.out.println("push - new_row: " + new_row + ",new_col: "+new_col);
                        queue.add(new Node(new_row,new_col));
                        visited[new_row][new_col]=true;
                    }
                }
            }
            count1++;
        }


        System.out.println(count1);

        // //적녹색 파악

        queue = new ArrayDeque<>();
        visited=new boolean[N][N];
        int count2 = 0;


        while((start = findNotVisited()) != null){
            queue.add(start);
            visited[start.row][start.col] = true;

            while(!queue.isEmpty()){
                Node now = queue.poll();

                for(int i=0;i<4;i++){
                    int new_row= now.row+dRow[i];
                    int new_col= now.col+dCol[i];

                    //범위 확인
                    if(new_row<0||new_col<0||new_row>=N||new_col>=N){
                        continue;
                    }

                    //이미 방문했는지 확인
                    if(visited[new_row][new_col]){
                        continue;
                    }

                    if(map[now.row][now.col]==map[new_row][new_col]){
                        queue.add(new Node(new_row,new_col));
                        visited[new_row][new_col]=true;
                    }else if(map[now.row][now.col]=='R'&&map[new_row][new_col]=='G'){
                        queue.add(new Node(new_row,new_col));
                        visited[new_row][new_col]=true;
                    }else if(map[now.row][now.col]=='G'&&map[new_row][new_col]=='R'){
                        queue.add(new Node(new_row,new_col));
                        visited[new_row][new_col]=true;
                    }
                }
            }
            count2++;
        }

        System.out.println(count2);


    }

    static class Node{
        int row;
        int col;

        public Node(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    private static Node findNotVisited(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]) return new Node(i,j);
            }
        }

        return null;
    }
}
