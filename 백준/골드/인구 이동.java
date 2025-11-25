import java.util.*;
import java.io.*;


class Main {
    private static boolean[][] visited;
    private static int[][] map;
    private static int N;
    private static int count =0;

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); //L명 이상
        int R = Integer.parseInt(st.nextToken()); //R명 이하

        map = new int[N][N];
        visited= new boolean[N][N];


        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
        Node notVisited;

        int[] dn = {-1,1,0,0};
        int[] dm = {0,0,-1,1};


        while(true){
            boolean isDone=true;
            visited= new boolean[N][N];
            while((notVisited=findmap())!=null){
                ArrayDeque<Node> queue = new ArrayDeque<>();
                ArrayList<Node> list = new ArrayList<>();

                queue.add(new Node(notVisited.n,notVisited.m));
                visited[notVisited.n][notVisited.m] = true;
                list.add(new Node(notVisited.n,notVisited.m));


                while(!queue.isEmpty()){
                    Node now = queue.poll();

                    for(int i=0;i<4;i++){
                        int new_n = now.n + dn[i];
                        int new_m = now.m + dm[i];

                        if(new_n<0 || new_m<0 || new_n >=N || new_m>=N){
                            continue;
                        }

                        int diff = Math.abs(map[new_n][new_m]-map[now.n][now.m]);

                        if(diff<L || diff>R){ //개방하지 않아야 된다면
                            continue;
                        }

                        if(!visited[new_n][new_m]){
                            visited[new_n][new_m] = true;
                            queue.add(new Node(new_n,new_m));
                            list.add(new Node(new_n,new_m));
                        }
                    }
                }

                int landCount = list.size();
                int landSum =0;
                for(Node land : list){
                    landSum += map[land.n][land.m];
                }
                int result;

                if(landCount==0){
                    result =0;
                }else{
                    result = landSum/landCount;
                }

                for(Node land : list){
                    map[land.n][land.m] = result;
                    if(landCount>1){
                        isDone=false;
                    }
                }

            }
            // System.out.println();
            // for(int i=0;i<N;i++){
            //   for(int j=0;j<N;j++){
            //     System.out.print(map[i][j]+" ");
            //   }
            //   System.out.println();
            // }

            if(isDone){
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    private static Node findmap(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    return new Node(i,j);
                }
            }
        }
        return null;
    }

    static class Node{
        int n;
        int m;

        public Node(int n,int m){
            this.n=n;
            this.m=m;
        }
    }
}
