import java.util.*;
import java.io.*;

class Main {
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,-1,1};

    private static int N;
    private static int M;
    private static int x;
    private static int y;
    private static int K;

    private static int[][] map;
    private static int[] dice;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map= new int[N][M];
        dice = new int[7];

        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st =new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int dir = Integer.parseInt(st.nextToken());
            roll(dir);
        }


    }

    private static void roll(int dir){
        int new_x = dx[dir-1] + x;
        int new_y = dy[dir-1] + y;

        // System.out.println("new_x : " + new_x + ", new_y : "+ new_y);

        if(new_x<0||new_y<0||new_x>=M||new_y>=N){
            return;
        }


        int temp = dice[3];

        if(dir==1){
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        }else if(dir ==2){
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        }else if(dir ==3){
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[1];
            dice[1] =temp;
        }else if(dir ==4){
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }

        if(map[new_y][new_x]==0){
            map[new_y][new_x]=dice[6];
        }else{
            dice[6] = map[new_y][new_x];
            map[new_y][new_x]=0;
        }



        // for(int i=1;i<=6;i++){
        //   System.out.print(dice[i]+" ");
        // }
        // System.out.println();
        x = new_x;
        y = new_y;
        System.out.println(dice[3]);
    }

}
