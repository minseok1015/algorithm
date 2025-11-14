import java.util.*;
import java.io.*;


class Main {
    private static int N;
    private static int answer;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(map[i][j],answer);
            }
        }


        dfs(map,0);

        System.out.println(answer);

    }

    private static void dfs(int[][] map,int depth){
        if(depth==5){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    answer= Math.max(answer,map[i][j]);
                }
            }
            return;
        }
        int[][] copy = new int[N][N];
        for(int i=0;i<N;i++){
            copy[i] = map[i].clone();
        }
        //왼쪽
        for(int i=0;i<N;i++){
            int index = 0;
            int block = 0;
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    if(map[i][j]==block){
                        map[i][index-1] = block*2;
                        block=0;
                        map[i][j] = 0;
                    }else{
                        block = map[i][j];
                        map[i][j] =0;
                        map[i][index]=block;
                        index++;
                    }
                }
            }
        }
        dfs(map,depth+1);
        for(int i=0;i<N;i++){
            map[i] = copy[i].clone();
        }
        //오른쪽
        for(int i=0;i<N;i++){
            int index = N-1;
            int block = 0;
            for(int j=N-1;j>=0;j--){
                if(map[i][j]!=0){
                    if(map[i][j]==block){
                        map[i][index+1] = block*2;
                        block=0;
                        map[i][j] = 0;
                    }else{
                        block = map[i][j];
                        map[i][j] =0;
                        map[i][index]=block;
                        index--;
                    }
                }
            }
        }
        dfs(map,depth+1);
        for(int i=0;i<N;i++){
            map[i] = copy[i].clone();
        }
        //위쪽
        for(int i=0;i<N;i++){
            int index = 0;
            int block = 0;
            for(int j=0;j<N;j++){
                if(map[j][i]!=0){
                    if(map[j][i]==block){
                        map[index-1][i] = block*2;
                        block=0;
                        map[j][i] = 0;
                    }else{
                        block = map[j][i];
                        map[j][i] =0;
                        map[index][i]=block;
                        index++;
                    }
                }
            }
        }
        dfs(map,depth+1);
        for(int i=0;i<N;i++){
            map[i] = copy[i].clone();
        }
        //아래쪽
        for(int i=0;i<N;i++){
            int index = N-1;
            int block = 0;
            for(int j=N-1;j>=0;j--){
                if(map[j][i]!=0){
                    if(map[j][i]==block){
                        map[index+1][i] = block*2;
                        block=0;
                        map[j][i] = 0;
                    }else{
                        block = map[j][i];
                        map[j][i] =0;
                        map[index][i]=block;
                        index--;
                    }
                }
            }
        }
        dfs(map,depth+1);

    }


}

/*
2
2 2
2 2

4
0 0 2 0
0 0 0 0
2 0 0 0
0 0 0 0

4
2 0 2 0
0 0 0 0
0 0 0 0
0 0 0 0

4
4 2 0 0
0 0 0 0
0 0 0 0
2 0 0 0

4
0 0 4 4
0 0 0 0
0 0 0 0
0 0 0 0

4
2 0 2 8
0 0 2 2
0 0 0 0
0 0 0 0

*/