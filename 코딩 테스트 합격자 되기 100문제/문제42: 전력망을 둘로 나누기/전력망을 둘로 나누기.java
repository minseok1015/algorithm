import java.util.*;

class Solution {

    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;

    private static int answer;
    private static int N;

    public int solution(int n, int[][] wires) {
        adList = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i<= n ; i++){
            adList[i] = new ArrayList<>();
        }

        for(int[] edge : wires){
            adList[edge[0]].add(edge[1]);
            adList[edge[1]].add(edge[0]);
        }

        N = n;
        answer =n;
        dfs(1);




        return answer;
    }

    private static int dfs(int now){
        visited[now] =true;
        int sum = 0;

        for(int next : adList[now]){
            if(!visited[next]){
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N-cnt-cnt));

                sum+=cnt;
            }
        }

        return sum+1;

    }


}

//1. 전력망을 인접리스트로 표현 (양방향)
//2. 간선도 저장
//3. 간선 하나씩 잘라봄
//4. dfs로 전력망 갯수 구해봄