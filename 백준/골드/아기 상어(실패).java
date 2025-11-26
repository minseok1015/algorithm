import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        ArrayList<Node> fish = new ArrayList<>();
        Node start = null;

        for(int i=0;i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    start= new Node(i,j,2);
                    map[i][j] =0;
                }else if(map[i][j]>0){
                    fish.add(new Node(i,j,0));
                }
            }
        }
        int[] dn = {-1,1,0,0};
        int[] dm = {0,0,-1,1};

        int count=0;

        int dis=Integer.MAX_VALUE;
        int short_n = N;
        int short_m = N;

        //남아 있는 물고기들 중에서 가장 짧은 거리에 있는 물고기들을 구함
        for(int i=0;i<fish.size();i++){
            Node curFish = fish.get(i);
            ArrayDeque<Node> queue = new ArrayDeque<>();
            int[][] visited = new boolean[N][N];

            queue.add(new Node(start.n,start.m,2));
            visited[start.n,start.m] = 1;

            while(!queue.isEmpty()){ //한 물고기를 정해서 그 물고기로 가는 거리의 최솟값을 구함
                Node now = queue.poll();

                if(now.n==curFish.n && now.m == curFish.m){
                    if(dis > visited[now.n][now.m]){
                        dis = visited[now.n][now.m];
                        short_n = now.n;
                        short_m = now.m;
                    }else if(dis == visited[now.n][now.m]){ //전에꺼랑 같은 가까운 거리인 경우
                        //거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                        if(now.n < short_n){
                            dis = visited[now.n][now.m];
                            short_n = now.n;
                            short_m = now.m;
                        }else if(now.n == short_n){
                            if(now.m < short_m){
                                dis = visited[now.n][now.m];
                                short_n = now.n;
                                short_m = now.m;
                            }
                        }
                    }
                    break;
                }

                for(int j=0;j<4;j++){
                    int new_n = now.n + dn[i];
                    int new_m= now.m + dm[i];

                    if(new_n<0 || new_m < 0 || new_n >=N || new_m >=N){
                        continue;
                    }

                    if(visited[new_n][new_m]!=0){ //방문 안한 곳 중에서
                        if(map[new_n][new_m] > now.size){ //지나가려는 곳이 더 크면
                            continue; //못감
                        }else if(map[new_n][new_m] == now.size){ //지나가려는 곳이 크기가 같다면
                            visited[new_n][new_m] = visited[now.n][now.m] + 1;
                            queue.add(new Node(new_n,new_m,now.size));
                        }else if(map[new_n][new_m] < now.size){ //지나가려는 곳이 크기가 작다면
                            visited[new_n][new_m] = visited[now.n][now.m] + 1;
                            queue.add(new Node(new_n,new_m,now.size+1)); //사이즈 증가
                            map[new_n][new_m] = 0;
                        }
                    }
                }

            }

        }

        // for(Node f : fish){
        //   System.out.print("[" + f.n +"," + f.m + "]"+" ");
        // }
        // System.out.println();
        // System.out.println(start.n +", " + start.m);


    }

    static class Node{
        int n;
        int m;
        int size;

        // public Node(int n,int m){
        //   this.n =n;
        //   this.m =m;
        // }

        public Node(int n,int m,int size){
            this.n =n;
            this.m =m;
            this.size =size;
        }
    }
}
