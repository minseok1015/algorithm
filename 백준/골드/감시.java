import java.util.*;
import java.io.*;


class Main {

    private static int answer;
    private static int N;
    private static int M;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        answer=N*M;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // for(int i=0;i<N;i++){
        //   for(int j=0;j<M;j++){
        //     System.out.print(map[i][j]+" ");
        //   }
        //   System.out.println();
        // }

        dfs(map);

        System.out.println(answer);

    }

    private static int[] find(int[][] map){
        // System.out.println();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                // System.out.print(map[i][j]+" ");
                if(map[i][j]>=1 && map[i][j]<=5){
                    return new int[]{map[i][j],i,j};
                }
            }
            // System.out.println();
        }
        return null;
    }

    private static void dfs(int[][] map){
        int[] cctv = find(map);
        if(cctv==null){
            int sum=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0){
                        sum++;
                    }
                }
            }
            answer = Math.min(answer,sum);
            return;
        }

        int cctvType = cctv[0];
        int n = cctv[1];
        int m = cctv[2];
        int[] dn = {-1,0,1,0};
        int[] dm = {0,1,0,-1};

        int[][] copy = new int[N][M];

        for(int i=0;i<N;i++){
            copy[i] = map[i].clone();
        }

        if(cctvType==1){
            for(int i=0;i<4;i++){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) {
                        map[new_n][new_m] = -1;
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];
                }

                dfs(map);

                for(int j=0;j<N;j++){
                    map[j] = copy[j].clone();
                }
            }
        }
        else if(cctvType==2){
            //위 아래
            for(int i=0;i<4;i+=2){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //왼 오른
            for(int i=1;i<4;i+=2){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }
            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
        }else if(cctvType==3){
            //위 오른
            for(int i=0;i<2;i++){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //오른 아래
            for(int i=1;i<3;i++){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //아래 왼
            for(int i=2;i<4;i++){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //왼 위
            for(int i=0;i<4;i++){
                if(i==1 || i==2){
                    continue;
                }
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }

        }else if(cctvType==4){
            //왼쪽 위 오른쪽
            for(int i=0;i<4;i++){
                if(i==3){
                    continue;
                }
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //위 오른쪽 아래
            for(int i=0;i<4;i++){
                if(i==2){
                    continue;
                }
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //오른쪽 아래 왼
            for(int i=0;i<4;i++){
                if(i==1){
                    continue;
                }
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
            //아래 왼 위
            for(int i=0;i<4;i++){
                if(i==0){
                    continue;
                }
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
        }else if(cctvType==5){
            //상하좌우
            for(int i=0;i<4;i++){
                map[n][m] = -1;
                int new_n = n+dn[i];
                int new_m = m+dm[i];

                if(new_n<0 || new_m<0 || new_n>= N|| new_m>=M){
                    continue;
                }
                while(new_n >= 0 && new_n < N && new_m >= 0 && new_m < M){
                    if (map[new_n][new_m] == 6) {
                        break;
                    }
                    if (map[new_n][new_m] == 0) { // 빈 칸(0)이면
                        map[new_n][new_m] = -1; // 감시 처리
                    }
                    new_n = new_n+dn[i];
                    new_m = new_m+dm[i];

                }

            }
            dfs(map);
            for(int j=0;j<N;j++){
                map[j] = copy[j].clone(); //다시 되돌리기
            }
        }

    }
}
