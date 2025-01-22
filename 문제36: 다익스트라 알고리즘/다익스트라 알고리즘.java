import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        System.out.println(Arrays.toString(solution(graph, 0, 3)));
        int[][] graph2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
        System.out.println(Arrays.toString(solution(graph2, 0, 4)));
    }

    // 노드의 정보(노드 번호와 거리)를 쌍으로 저장할 클래스 생성
    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    // 이 부분을 변경해서 실행해보세요.
    public static int[] solution(int[][] graph, int start, int n) {
        ArrayList[] adjList = new ArrayList[n];
        for(int i = 0 ; i<n ; i ++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : graph){
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Ndoe> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));

        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.dest]) {
                continue;
            }

            visited[now.dest]=true;

            for(Node next : adjList[now.dist]){
                if(distance[now.dist]< now.dist+next.dist){
                    distance[now.dist] = now.dist+next.dist;
                    pq.add(new Node(next.dist,distance[now.dist]));
                }
            }

        }
        return distance;
    }

}