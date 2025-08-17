import java.util.*;
import java.io.*;


class Main {
    private static int[][] results;
    private static boolean[] visited;
    private static List<Integer> result;
    private static int answer;
    private static int N;


    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        results = new int[N][9];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited= new boolean[10];
        result = new ArrayList<>();


        dfs(0);


        System.out.println(answer);

    }

    private static void dfs(int depth){
        if(depth==8){
            //나온 순서로 게임진행
            result.add(3,1);
            answer = Math.max(answer,game());

            // for(int i=0;i<9;i++){
            //   System.out.print(result.get(i)+" ");
            // }
            // System.out.println();
            result.remove(3);
        }



        for(int i=2;i<=9;i++){
            if(!visited[i]){
                visited[i] = true;
                result.add(i);
                dfs(depth+1);
                result.remove(result.size()-1);
                visited[i]=false;
            }
        }
    }


    private static int game(){
        int score =0;
        int inning=1;

        int order =0;

        while(inning<=N){
            int out = 0;
            boolean[] base = new boolean[4];
            while(out<3){
                int now = result.get((order)%9)-1;

                if(results[inning-1][now]==0){
                    out++;
                }else if(results[inning-1][now]==1){
                    if(base[3]) score++; base[3]=false;
                    if(base[2]) base[3]=true; base[2]=false;
                    if(base[1]) base[2]=true; base[1]=false;
                    base[1]=true;
                }else if(results[inning-1][now]==2){
                    if(base[3]) score++; base[3]=false;
                    if(base[2]) score++; base[2]=false;
                    if(base[1]) base[3]=true; base[1]=false;
                    base[2]=true;
                }else if(results[inning-1][now]==3){
                    if(base[3]) score++; base[3]=false;
                    if(base[2]) score++; base[2]=false;
                    if(base[1]) score++; base[1]=false;
                    base[3]=true;
                }else if(results[inning-1][now]==4){
                    if(base[3]) score++; base[3]=false;
                    if(base[2]) score++; base[2]=false;
                    if(base[1]) score++; base[1]=false;
                    score++;
                }
                order++;
            }
            inning++;
        }

        return score;
    }
}
