import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        int[][] map = new int[N][M];  //0: 빈공간, 1: 벽, 파란공: 2, 빨간공: 3, 구멍 : 4
        int start_red_m=0;
        int start_red_n=0;
        int start_blue_m=0;
        int start_blue_n=0;
        int hole_m=0;
        int hole_n=0;

        for(int i=0;i<N;i++){
            String input  = br.readLine();
            for(int j=0;j<M;j++){
                char c = input.charAt(j);
                if(c=='#'){
                    map[i][j] = 1;
                }else if(c=='.'){
                    map[i][j] = 0;
                }else if(c=='B'){
                    map[i][j] = 2;
                    start_blue_m=i;
                    start_blue_n=j;
                }else if(c=='R'){
                    map[i][j] = 3;
                    start_red_m=i;
                    start_red_n=j;
                }else if(c=='O'){
                    map[i][j] = 4;
                    hole_m=i;
                    hole_n=j;
                }
            }
        }

        // System.out.println(start_red_m+", " +start_red_n+", " +start_blue_m+", "+start_blue_n);


        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start_red_m,start_red_n,start_blue_m,start_blue_n,1));
        boolean[][][][] visited = new boolean[N][M][N][M]; //(빨강_m, 빨강_n, 파랑_m, 파랑_n)으로 방문확인
        visited[start_red_m][start_red_n][start_blue_m][start_blue_n] = true;

        int answer=-1;

        int[] dm = {-1,0,1,0};  // 위, 오른쪽, 아래, 왼쪽
        int[] dn = {0,1,0,-1};

        outer:
        while(!queue.isEmpty()){
            Node now= queue.poll();

            if(now.depth>10){
                break;
            }

            for(int i=0;i<4;i++){
                boolean isRed=false;//빨간공이 구멍에 들어갔나
                boolean isBlue=false;//파란공이 구멍에 들어갔나
                int new_red_m = now.red_m;
                int new_red_n = now.red_n;
                int new_blue_m = now.blue_m;
                int new_blue_n = now.blue_n;
                //빨간공 움직이기
                while(map[new_red_m+dm[i]][new_red_n+dn[i]] !=1){ //벽일때까지
                    new_red_m += dm[i];
                    new_red_n += dn[i];
                    if(map[new_red_m][new_red_n]==4){ //구멍이면
                        isRed=true;
                        break;
                    }
                }

                //파란공 움직이기
                while(map[new_blue_m+dm[i]][new_blue_n+dn[i]] !=1){ //벽일때까지
                    new_blue_m += dm[i];
                    new_blue_n += dn[i];
                    if(map[new_blue_m][new_blue_n]==4){ //구멍이면
                        isBlue=true;
                        break;
                    }
                }
                // System.out.println("i: " + i + ",isBlue : " +isBlue+",isRed : " +isRed);

                //파란공이 들어간 경우
                if(isBlue){
                    continue;
                }
                //빨간공만 들어간 경우
                if(isRed && !isBlue){
                    answer = now.depth;
                    break outer;
                }

                // System.out.println("겹치기 체크 전, "+"i: " +i+": "+ new_red_m+ ", " + new_red_n + ", " + new_blue_m+ ", " + new_blue_n);

                //빨간공 파란공 위치가 겹치는 경우
                if(new_red_m==new_blue_m && new_red_n==new_blue_n){
                    //수평에서 겹치는 경우
                    if(i==1){   //오른쪽으로 움직였을 때
                        if(now.red_n<now.blue_n){ //빨간색이 왼쪽에 있었을 경우
                            new_red_n-=1;
                        }else{
                            new_blue_n-=1;
                        }
                    }
                    if(i==3){  //왼쪽으로 움직였을 때
                        if(now.red_n<now.blue_n){ //빨간색이 왼쪽에 있었을 경우
                            new_blue_n+=1;
                        }else{
                            new_red_n+=1;
                        }
                    }
                    //수직에서 겹치는 경우
                    if(i==0){//위로 움직였을때
                        if(now.red_m < now.blue_m){ //빨간색이 위쪽에 있었을 경우
                            new_blue_m+=1;
                        }else{
                            new_red_m+=1;
                        }
                    }

                    if(i==2){ //아래로 움직였을때
                        if(now.red_m < now.blue_m){ //빨간색이 위쪽에 있었을 경우
                            new_red_m-=1;
                        }else{
                            new_blue_m-=1;
                        }
                    }

                }

                // System.out.println("겹치기 체크 후, "+"i: " +i+": "+ new_red_m+ ", " + new_red_n + ", " + new_blue_m+ ", " + new_blue_n);

                //빨간공 파란공 둘다 안들어간 경우
                if(!visited[new_red_m][new_red_n][new_blue_m][new_blue_n]){
                    visited[new_red_m][new_red_n][new_blue_m][new_blue_n] = true;
                    // System.out.println("i: " +i+": "+ new_red_m+ ", " + new_red_n + ", " + new_blue_m+ ", " + new_blue_n);
                    queue.add(new Node(new_red_m,new_red_n,new_blue_m,new_blue_n,now.depth+1));
                }

            }


        }

        System.out.println(answer);



    }

    static class Node{
        int red_m;
        int red_n;
        int blue_m;
        int blue_n;
        int depth;

        public Node(int red_m,int red_n, int blue_m, int blue_n,int depth){
            this.red_m = red_m;
            this.red_n = red_n;
            this.blue_m = blue_m;
            this.blue_n = blue_n;
            this.depth = depth;
        }
    }
}
