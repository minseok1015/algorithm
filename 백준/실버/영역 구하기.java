import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());  // 5
        int N = Integer.parseInt(st.nextToken());  // 7
        int K = Integer.parseInt(st.nextToken());  // 3

        int[][] board = new int[M][N];
        // boolean[][] visited = new boolean[N][M];

        // 입력 받아서 보드 채우기
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int left_x= Integer.parseInt(st.nextToken());  // 0
            int left_y= Integer.parseInt(st.nextToken());  // 2
            int right_x= Integer.parseInt(st.nextToken()); // 4
            int right_y= Integer.parseInt(st.nextToken()); // 4

            int m_start = M-right_y;
            int m_end = M-left_y-1;
            int n_start = left_x;
            int n_end = right_x-1;

            for(int j=m_start;j<=m_end;j++){
                for(int k=n_start;k<=n_end;k++){
                    board[j][k] = 1;
                }
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        int answer=0;


        int[] dm = {-1,1,0,0};
        int[] dn = {0,0,-1,1};

        int[] start;
        while ((start = find(board)) != null) {
            queue.add(new Node(start[0],start[1]));
            list.add(0);
            // System.out.println("start[0] : " + start[0] + ", start[1] : " + start[1]);

            while(!queue.isEmpty()){
                Node now = queue.poll();

                if(board[now.m][now.n]!=0){
                    // System.out.println("continue : " + ",now.m : " + now.m + ", now.n : " + now.n);
                    continue;
                }
                board[now.m][now.n] = -1;
                list.set(list.size()-1,list.get(list.size()-1)+1);

                // System.out.println("now.m : "+ now.m + ", now.n : " +now.n);

                // for(int i=0;i<M;i++){
                //   for(int j=0;j<N;j++){
                //     System.out.print(board[i][j]+" ");
                //   }
                //   System.out.println();
                // }

                for(int i=0;i<4;i++){
                    int new_m = now.m + dm[i];
                    int new_n = now.n + dn[i];

                    if(new_m<0 ||new_m>=M || new_n<0 || new_n>=N){ //board 범위를 벗어날 경우 pass
                        continue;
                    }

                    if(board[new_m][new_n]!=0){  //이미 방문한 곳이면 pass
                        continue;
                    }
                    // board[new_m][new_n]= -1;
                    queue.add(new Node(new_m,new_n));
                    // System.out.println("큐 추가 : " + ", new_m : " + new_m + ", new_n : " + new_n);

                }
            }
        }

        System.out.println(list.size());
        list.sort((a,b)->a-b);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }


    }

    private static int[] find(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    static class Node{
        int m;
        int n;

        public Node(int m, int n){
            this.m = m;
            this.n = n;
        }
    }
}
