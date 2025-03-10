import java.util.*;
import java.io.*;


public class Main {

    private static class Node{
        int dist;
        int cost;

        public Node(int dist, int cost){
            this.dist=dist;
            this.cost = cost;
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] adList = new ArrayList[V+1];


        for(int i = 0 ; i <= V ; i++ ){
            adList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++){
            String[] edges = br.readLine().split(" ");
            adList[Integer.parseInt(edges[0])].add(new Node(Integer.parseInt(edges[1]),Integer.parseInt(edges[2])));
        }

        boolean[] visited = new boolean[V+1];
        int[] distance = new int[V+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[K]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));

        pq.add(new Node(K,0));


        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.dist]){
                continue;
            }

            visited[now.dist]=true;

            for(Node next : adList[now.dist]){
                if(distance[next.dist]> now.cost + next.cost){
                    distance[next.dist] = now.cost + next.cost;
                    pq.add(new Node(next.dist,distance[next.dist]));
                }
            }
        }

        for(int i =1 ; i<=V ; i++){
            if(!visited[i]){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }

        return;
    }
}