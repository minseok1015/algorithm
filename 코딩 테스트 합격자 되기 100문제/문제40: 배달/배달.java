import java.util.*;

class Solution {
    class Node{
        int dest;
        int cost;

        public Node(int d, int c){
            this.dest = d;
            this.cost = c;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adList = new ArrayList[N+1];
        for(int i = 0 ;  i<= N; i++){
            adList[i] = new ArrayList<>();
            // adList[i].add(new Node(i,0));
        }

        for(int[] edge : road){
            adList[edge[0]].add(new Node(edge[1],edge[2]));
            adList[edge[1]].add(new Node(edge[0],edge[2]));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];


        Arrays.fill(distance,Integer.MAX_VALUE);

        queue.add(new Node(1,0));
        distance[1]= 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(visited[now.dest]){
                continue;
            }
            visited[now.dest] = true;

            for(Node next : adList[now.dest]){
                if(distance[next.dest] > next.cost + now.cost){
                    distance[next.dest] = next.cost + now.cost;
                    queue.add(new Node(next.dest,distance[next.dest]));
                }
            }
        }

        return (int)Arrays.stream(distance).filter(d -> d<= K).count();


    }
}