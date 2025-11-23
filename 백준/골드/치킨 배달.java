import java.util.*;
import java.io.*;

class Main {
    private static int MaxDepth;
    private static int N;
    private static int answer;

    private static List<Node> chickens = new ArrayList<>();
    private static List<Node> houses = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N]; // 0: 빈칸, 1: 집, 2: 치킨집

        int chicken = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                } else if (map[i][j] == 1) {
                    houses.add(new Node(i, j));
                }
            }
        }

        //없애야 하는 치킨 집 갯수 계산
        MaxDepth= chickens.size() - M;
        answer = Integer.MAX_VALUE;

        dfs(0, 0, map);

        System.out.println(answer);

    }

    private static void dfs(int depth,int start, int[][] map){
        if(depth==MaxDepth){
            // for(int i=0;i<N;i++){
            //   for(int j=0;j<N;j++){
            //     System.out.print(map[i][j]+" ");
            //   }
            //   System.out.println();
            // }

            // System.out.println();

            answer = Math.min(answer,chickenDistance(map));
            return;
        }


        for (int i = start; i < chickens.size(); i++) {
            Node c = chickens.get(i);

            map[c.n][c.m] = 0;   // 제거
            dfs(depth + 1, i + 1, map);
            map[c.n][c.m] = 2;   // 복구
        }
    }

    // private static int chickenDistance(int[][] map){
    //   int distance =0;
    //   int[] dn = {-1,1,0,0};
    //   int[] dm = {0,0,-1,1};

    //   for(int i=0;i<N;i++){
    //     for(int j=0;j<N;j++){
    //       if(map[i][j]==1){ //집이면
    //         ArrayDeque<Node> queue = new ArrayDeque<>();
    //         int[][] visited = new int[N][N];
    //         int chickendis = 0;

    //         queue.add(new Node(i,j));
    //         visited[i][j] = 1;

    //         while(!queue.isEmpty()){
    //           Node now = queue.poll();

    //           if(map[now.n][now.m]==2){//치킨 집이면
    //             distance += visited[now.n][now.m]-1;
    //             break;
    //           }

    //           for(int k=0;k<4;k++){
    //             int new_n = now.n+dn[k];
    //             int new_m = now.m+dm[k];

    //             if(new_n<0 || new_m<0 || new_n>=N || new_m>=N){
    //               continue;
    //             }

    //             if(visited[new_n][new_m]==0){
    //               queue.add(new Node(new_n,new_m));
    //               visited[new_n][new_m] = visited[now.n][now.m]+1;
    //             }

    //           }
    //         }
    //       }
    //     }
    //   }

    //   return distance;
    // }

    private static int chickenDistance(int[][] map) {
        int distanceSum = 0;

        for (Node h : houses) {
            int minDist = Integer.MAX_VALUE;

            for (Node c : chickens) {
                if (map[c.n][c.m] == 2) {  // 살아남은 치킨집만 계산
                    int dist = Math.abs(h.n - c.n) + Math.abs(h.m - c.m);
                    minDist = Math.min(minDist, dist);
                }
            }

            distanceSum += minDist;
        }

        return distanceSum;
    }


    static class Node{
        int n;
        int m;

        public Node(int n, int m){
            this.n = n;
            this.m = m;
        }
    }
}
