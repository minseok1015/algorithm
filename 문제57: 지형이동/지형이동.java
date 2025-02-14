import java.util.*;

class Solution {
    private static class Node{
        int i;
        int j;
        int cost;

        public Node(int i,int j,int cost){
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    private static final int[] di ={1,-1,0,0};
    private static final int[] dj ={0,0,-1,1};

    public int solution(int[][] land, int height) {
        int answer = 0;
        boolean[][] visited = new boolean[land.length][land[0].length];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));

        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){
            Node now= pq.poll();

            if(visited[now.i][now.j]) continue;
            visited[now.i][now.j] = true;

            answer+=now.cost;

            for(int i = 0 ; i <4 ; i++){
                int new_i = now.i+di[i];
                int new_j = now.j+dj[i];


                if(new_i<0 || new_j<0 || new_i >= land.length || new_j >= land[0].length){
                    continue;
                }

                int temp=Math.abs(land[now.i][now.j] - land[new_i][new_j]);

                if(temp> height){
                    pq.add(new Node(new_i,new_j,temp));
                }else{
                    pq.add(new Node(new_i,new_j,0));
                }

            }

        }
        return answer;

    }
}