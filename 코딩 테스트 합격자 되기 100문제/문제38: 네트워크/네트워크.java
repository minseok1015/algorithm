import java.util.*;

class Solution {
    private static boolean[] visited;
    private ArrayDeque<Integer> stack = new ArrayDeque<>();


    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        stack.push(0);

        for(int j =0 ; j< n ; j++){
            if(visited[j]){
                continue;
            }
            stack.push(j);
            while(!stack.isEmpty()){
                int now = stack.pop();
                visited[now]=true;
                for(int i = 0 ; i< computers[now].length; i ++){
                    if(!visited[i] && computers[now][i]==1){
                        stack.push(i);
                        System.out.println("스택에 넣음 : "+ (i+1));
                    }
                }
            }
            System.out.println("answer증가!");
            answer++;
        }

        return answer;
    }


}