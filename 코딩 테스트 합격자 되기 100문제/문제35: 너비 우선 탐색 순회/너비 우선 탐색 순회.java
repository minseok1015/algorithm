import java.util.*;

class Solution {


    private static ArrayList[] adList;  //그래프를 표현할 인접 리스트
    private static boolean[] visited;  //노드에 방문했는지 체크하는 배열

    private static ArrayList<Integer> answer = new ArrayList<>();   //정답을 담아둘 ArrayList

    private static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static int[] solution(int[][] graph, int start, int n) {
        adList = new ArrayList[n+1];

        for(int i = 0 ; i< adList.length ; i++){
            adList[i] = new ArrayList<>();
        }
        for(int[] edge:  graph){
            adList[edge[0]].add(edge[1]);
        }
        //그래프를 인접 리스트에 저장

        visited = new boolean[n+1];


        //먼저 처음 노드를 추가 해둠
        queue.addLast(start);
        visited[start] = true;

        bfs();

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    public void bfs(){
        while(!queue.isEmpty()){
            int node = queue.offerFirst();
            answer.add(node);
            for(int n : adList[node]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.addLast(n);
                }
            }
        }
    }

}