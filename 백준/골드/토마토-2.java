//https://www.acmicpc.net/problem/7569

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] visited = new int[H][N][M];
        int[][][] map = new int[H][N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();


        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st =new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1){
                        queue.add(new Node(i,j,k));
                        visited[i][j][k]++;
                    }
                }
            }
        }

        // for(int i=0;i<H;i++){
        //   for(int j=0;j<N;j++){
        //     for(int k=0;k<M;k++){
        //        System.out.print(map[i][j][k]);
        //     }
        //     System.out.println();
        //   }
        //   System.out.println();
        // }

        //위 아래 왼쪽 오른쪽 앞 뒤
        int[] dh = {1,-1,0,0,0,0};
        int[] dn = {0,0,-1,1,0,0};
        int[] dm = {0,0,0,0,-1,1};

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i =0;i<6;i++){
                int next_h= now.h+dh[i];
                int next_n= now.n+dn[i];
                int next_m= now.m+dm[i];

                if(next_h<0 || next_m<0 || next_n<0 || next_h>=H || next_m>=M || next_n>=N){
                    continue;
                }

                if(map[next_h][next_n][next_m]==-1){
                    continue;
                }

                if(visited[next_h][next_n][next_m]>0){
                    continue;
                }

                queue.add(new Node(next_h,next_n,next_m));
                visited[next_h][next_n][next_m] = visited[now.h][now.n][now.m]+1;
            }

            // for(int i=0;i<H;i++){
            //   for(int j=0;j<N;j++){
            //     for(int k=0;k<M;k++){
            //        System.out.print(visited[i][j][k]);
            //     }
            //     System.out.println();
            //   }
            //   System.out.println();
            // }
        }

        int max = -1;
        int min = N*M*H;
        boolean flag=false;


        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    max = Math.max(max,visited[i][j][k]);
                    min = Math.min(min,visited[i][j][k]);
                    if (map[i][j][k] == 0 && visited[i][j][k] == 0)
                        flag = true;
                }
            }
        }


        if (flag)          System.out.println(-1);      // 전파 불가
        else if (max == 1)    System.out.println(0);       // 처음부터 모두 익음
        else                  System.out.println(max - 1); // 걸린 날짜




    }

    static class Node{
        int n;
        int m;
        int h;

        public Node(int h,int n,int m){
            this.n =n;
            this.m =m;
            this.h =h;
        }
    }
}

/**

 5 5 2
 1 0 1 -1 1
 0 1 0 1 0
 1 0 1 0 1
 0 1 0 1 0
 1 0 1 0 -1
 -1 -1 0 0 0
 0 0 0 0 0
 1 1 1 1 1
 0 0 0 0 0
 1 1 1 1 1

 **/