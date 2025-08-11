import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adjList = new ArrayList[N+1];

        for(int i=0;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }


        //X에서 자기집으로 돌아가는 비용 먼저 계산
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(X,0));

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=-1;
        dist[X]=0;


        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.dest]<now.cost){
                continue;
            }

            for(Node next: adjList[now.dest]){
                if(dist[next.dest]>now.cost+next.cost){
                    dist[next.dest] = now.cost+next.cost;
                    pq.add(new Node(next.dest,dist[next.dest]));
                }
            }
        }

        // for(int i=1;i<=N;i++){
        //   System.out.print(dist[i]+" ");
        // }
        // System.out.println();

        for(int i=1;i<=N;i++){
            pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));
            pq.add(new Node(i,0));

            int[] dist2 = new int[N+1];
            Arrays.fill(dist2, Integer.MAX_VALUE);
            dist2[0]=-1;
            dist2[i]=0;


            while(!pq.isEmpty()){
                Node now = pq.poll();

                if(dist2[now.dest]<now.cost){
                    continue;
                }

                for(Node next: adjList[now.dest]){
                    if(dist2[next.dest]>now.cost+next.cost){
                        dist2[next.dest] = now.cost+next.cost;
                        pq.add(new Node(next.dest,dist2[next.dest]));
                    }
                }
            }

            // System.out.println(i+" 에서 시작");
            // for(int j=1;j<=N;j++){
            //   System.out.print(dist2[j]+" ");
            // }
            // System.out.println();

            dist[i] += dist2[X];
        }

        System.out.println(Arrays.stream(dist).max().getAsInt());


    }

    static class Node{
        int cost;
        int dest;

        public Node(int d, int c){
            this.dest = d;
            this.cost = c;
        }
    }
}
