import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] runway = new int[N][N];  //내려가는거 -1, 없으면 0, 올라가는거 +1

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer =0;

        //가로 방향 조사
        A:for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                if(map[i][j]==map[i][j+1]){//높이가 같은 경우
                    continue; //그냥 지나감
                }
                if( Math.abs(map[i][j]-map[i][j+1]) > 1 ) { //높이 차이가 1 넘을 경우
                    continue A; //다음줄로 넘어감
                }
                if(map[i][j] == map[i][j+1] +1 ){  //현재 위치가 1칸 높을 경우
                    //다음 칸에 내려가는 경사로를 넣어야됨.
                    if((j+L) >= N){
                        continue A;
                    }
                    for(int k=1 ;k<L; k++){
                        if(map[i][j+1]!=map[i][j+1+k]){ //경사로를 놓을 위치가 평평한지
                            continue A;
                        }
                    }
                    for(int k=0 ;k<L; k++){
                        runway[i][j+1+k] = -1;  //경사로를 넣음
                    }
                }
                if(map[i][j]+1 == map[i][j+1]){ //현재 위치가 1칸 낮을 경우
                    //현재 칸에 경사로가 있으면 타고가면 됨
                    if(runway[i][j]==1){ //올라가는 경사로가 있으면
                        continue; //그냥 타고가면 됨
                    }
                    if(runway[i][j]==-1){//내려가는 경사로가 있으면
                        continue A;
                    }
                    //현재 칸에 경사로가 없으면 경사로를 만듬(만들때 길이 확인하고 만듬. 그때 이미 있어도 안됨)
                    if((j-L+1) < 0){
                        continue A;
                    }
                    for(int k=1;k<L;k++){
                        if(map[i][j]!=map[i][j-k] || runway[i][j-k]==-1){
                            continue A;
                        }
                    }
                    for(int k=0;k<L;k++){
                        runway[i][j-k] = 1; //올라가는 경사로 넣음
                    }
                }
            }
            // System.out.println("지나갈 수 있음 가로; i: " +i );
            answer++;
        }

        runway = new int[N][N];  //경사로 초기화
        //세로 방향 조사
        B:for(int j=0;j<N;j++){
            for(int i=0;i<N-1;i++){
                if(map[i][j]==map[i+1][j]){//높이가 같은 경우
                    continue; //그냥 지나감
                }
                if( Math.abs(map[i][j]-map[i+1][j]) > 1 ) { //높이 차이가 1 넘을 경우
                    continue B; //다음줄로 넘어감
                }
                if(map[i][j] == map[i+1][j] +1 ){  //현재 위치가 1칸 높을 경우
                    //다음 칸에 내려가는 경사로를 넣어야됨.
                    if((i+L) >= N){
                        continue B;
                    }
                    for(int k=1 ;k<L; k++){
                        if(map[i+1][j]!=map[i+1+k][j]){ //경사로를 놓을 위치가 평평한지
                            continue B;
                        }
                    }
                    for(int k=0 ;k<L; k++){
                        runway[i+1+k][j] = -1;  //경사로를 넣음
                    }
                }
                if(map[i][j]+1 == map[i+1][j]){ //현재 위치가 1칸 낮을 경우
                    //현재 칸에 경사로가 있으면 타고가면 됨
                    if(runway[i][j]==1){ //올라가는 경사로가 있으면
                        continue; //그냥 타고가면 됨
                    }
                    if(runway[i][j]==-1){//내려가는 경사로가 있으면
                        continue B;
                    }
                    //현재 칸에 경사로가 없으면 경사로를 만듬(만들때 길이 확인하고 만듬. 그때 이미 있어도 안됨)
                    if((i-L+1) < 0){
                        continue B;
                    }

                    for(int k=1;k<L;k++){
                        if(map[i][j]!=map[i-k][j] || runway[i-k][j]==-1){
                            continue B;
                        }
                    }
                    for(int k=0;k<L;k++){
                        runway[i-k][j] = 1; //올라가는 경사로 넣음
                    }
                }
            }
            // System.out.println("지나갈 수 있음 세로; j: " +j );
            answer++;

        }

        System.out.println(answer);


    }
}
