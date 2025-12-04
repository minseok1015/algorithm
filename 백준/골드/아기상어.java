import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        Node baby = null;
        int[] dn = {0,0,-1,1};
        int[] dm = {-1,1,0,0};


        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    baby = new Node(i,j,0);
                    map[i][j]=0;
                }
            }
        }

        int size=2;
        int eat=0;
        int count=0;


        while(true){
            ArrayDeque<Node> queue = new ArrayDeque<>();
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
                if(a.cost!=b.cost) return a.cost-b.cost;
                if (a.n != b.n) return a.n - b.n;
                return a.m - b.m;
            });
            boolean[][] visited= new boolean[N][N];

            queue.add(baby);
            visited[baby.n][baby.m] = true;

            while(!queue.isEmpty()){
                Node now = queue.poll();

                if(map[now.n][now.m]!=0){ //물고기가 있으면
                    if(size > map[now.n][now.m]){//아기상어모다 사이즈가 작다면(즉, 먹을 수 있다면)
                        pq.add(new Node(now.n,now.m,now.cost)); // 우선순위 큐에 추가
                        // System.out.println("n : " + now.n + ", m : " +now.m );
                    }
                }

                for(int i=0;i<4;i++){
                    int new_n = now.n + dn[i];
                    int new_m = now.m + dm[i];

                    if(new_n<0 || new_m <0 || new_n >=N || new_m >= N){
                        continue;
                    }

                    if(!visited[new_n][new_m]&& size >= map[new_n][new_m]){
                        visited[new_n][new_m] = true;
                        queue.add(new Node(new_n,new_m,now.cost+1));
                        // System.out.println("now.n : " + now.n + ", now.m : " +now.m  + ", new_n : " + new_n + ", new_m : " + new_m);
                    }
                }

            }

            //우선순위 큐에는 현재 상어 위치에서 먹으러 갈 수 있는 물고기 위치들이 있음
            //그 중에 가장 우선순위가 높은 것을 뽑아서 먹으러 가면 됨
            Node fish = null;
            if(!pq.isEmpty()){
                fish = pq.poll();
                // System.out.println("뽑!");
            }else{
                break;
            }

            map[fish.n][fish.m] = 0; //먹고 빈칸
            eat++; //먹은 마리 수 증가
            count+= fish.cost; //이동 거리 증가

            if(eat>=size){//먹은 마리 수가 현재 사이즈 만큼이면
                size++; //사이즈 증가
                eat=0; //먹은 마리 수 초기화
            }
            baby = new Node(fish.n,fish.m,0); //상어 위치 재조정

        }

        System.out.println(count);


    }

    static class Node{
        int n;
        int m;
        int cost;

        public Node(int n, int m,int cost){
            this.n = n;
            this.m = m;
            this.cost = cost;
        }
    }
}
