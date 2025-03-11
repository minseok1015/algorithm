import java.io.*;
import java.util.*;

class Main {
    private static class Node{
        int dest;
        int cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int  INF = 100000000;
        int[][] distance =new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            Arrays.fill(distance[i],INF);
        }



        for(int i = 0 ; i <M ; i++){
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            distance[v1][v2] = Math.min(c,distance[v1][v2]);
        }

        for(int k=1 ; k<=N ; k++){
            for(int i=1; i<=N ; i++){
                if(k==i) continue;
                for(int j=1; j<=N; j++){
                    if(k==j) continue;
                    if(i==j) continue;
                    distance[i][j]= Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                    // System.out.println("i :" + i+ ",j : " + j + ",val : " + distance[i][j]);
                }
            }
        }

        for(int i = 1 ; i<=N;i++){
            StringBuilder sb =new StringBuilder();
            for(int j=1;j<=N;j++){
                if(distance[i][j]==INF){
                    sb.append(0);
                }else{
                    sb.append(distance[i][j]);
                }
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }


    }
}
