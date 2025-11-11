import java.util.*;
import java.io.*;


class Main {
    private static int N;
    private static int[][] power;
    private static int answer;

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        power = new int[N][N];

        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer=Integer.MAX_VALUE;
        dfs(visited,0,0);

        System.out.println(answer);

    }

    private static void dfs(boolean[] visited, int index, int depth){
        if(depth == N/2){
            answer = Math.min(answer,calculate(visited));
        }

        for(int i=index;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(visited,i,depth+1);
                visited[i] = false;
            }
        }

    }

    private static int calculate(boolean[] visited){
        int team1=0;
        int team2=0;

        // for(int i=0;i<N;i++){
        //   if(visited[i]){
        //     System.out.print("1 ");
        //   }else{
        //     System.out.print("0 ");
        //   }
        // }
        // System.out.println();

        for(int i=0;i<N;i++){
            if(visited[i]){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(visited[j]){
                        team1+=power[i][j];
                        // System.out.println("team1 = " +  team1  + ", i : " + i  + ", j : " + j);
                    }
                }
            }else{
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(!visited[j]){
                        team2+=power[i][j];
                        // System.out.println("team2 = " +  team2  + ", i : " + i  + ", j : " + j);
                    }

                }
            }
        }



        // System.out.println(Math.abs(team1-team2));

        return Math.abs(team1-team2);
    }
}
