import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        st =new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 0-북, 1-동, 2-남, 3-서

        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer=0;

        // 0-북, 1-동, 2-남, 3-서
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(true){

            // System.out.println("r: "+r +", c: "+c);

            //1. 현재칸 청소
            if(map[r][c]==0){
                map[r][c]=-1;
                answer++;
            }

            //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,(주변이 청소가 된 경우(단,벽제외))
            boolean isClean = true;
            for(int i=0;i<4;i++){
                int new_r = r +dr[i];
                int new_c = c +dc[i];

                if(new_r<0 || new_r>=N || new_c<0 || new_c>=M){  //map의 범위를 벗어난 경우
                    continue;
                }

                if(map[new_r][new_c]==0){
                    isClean=false;
                    break;
                }
            }


            if(isClean){ //청소가 다 된 경우 (2-1후진, 또는 2-2그만)
                int new_r = r +dr[(d+2)%4];
                int new_c = c +dc[(d+2)%4];

                if(map[new_r][new_c]==1){  //벽일 경우
                    break;
                }

                //벽이 아니면 후진
                r= new_r;
                c= new_c;

            }else{ // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                for(int i=0;i<4;i++){
                    d= (d+3) % 4; //1. 반시계 방향으로 90도 회전한다.
                    int new_r = r +dr[d];
                    int new_c = c +dc[d];

                    // System.out.println("new_r : " +new_r+", new_c : "+new_c);

                    if(map[new_r][new_c]==0){ //2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                        r=new_r;
                        c=new_c;
                        break;
                    }
                }
            }



        }

        // for(int i=0;i<N;i++){
        //   for(int j=0;j<M;j++){
        //     System.out.print(map[i][j]+" ");
        //   }
        //   System.out.println();
        // }

        System.out.println(answer);

    }
}


/**

 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.

 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.

 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
 1. 반시계 방향으로 90도 회전한다.
 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
 3. 1번으로 돌아간다.

 **/