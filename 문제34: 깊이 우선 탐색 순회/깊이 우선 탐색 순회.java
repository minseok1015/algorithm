import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adList;//인접리스트

    private static boolean[] visited;

    private static ArrayList<Integer> answer = new ArrayList<>();


    public static int[] solution(int[][] graph, int start, int n) {
        adList= new ArrayList[n+1];

        for(int i = 0 ; i<adList.length ; i++){
            adList[i] = new ArrayList<>();
        }

        //인접 리스트로 그래프 표현
        for(int[] edge : graph) {
            adList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n+1];

        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(int node){
        visited[node] = true;
        answer.add(node);
        for(int next : adList[node]){
            if(!visited[next]){
                dfs(next);
            }
        }

    }
}