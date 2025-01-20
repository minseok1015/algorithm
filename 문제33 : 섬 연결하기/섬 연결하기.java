import java.util.*;

class Solution {
    int[] parent;

    public int find(int x){
        if(parent[x]==x){//자기가 루트일 경우(자기가 최상위 루트일 경우)
            return x;
        }else{
            return find(parent[x]);
        }
    }

    public void union(int x1, int x2){
        int root1= find(x1);
        int root2 = find(x2);
        parent[root1]= root2;
    }


    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0 ; i < n ;i ++){   //자기 자신으로 초기화
            parent[i] = i;
        }

        Arrays.sort(costs,(o1,o2)-> Integer.compare(o1[2],o2[2]));

        int answer = 0 ;
        int edge = 0;

        for(int[] cost : costs){
            if(edge == n-1){//모든 간선을 다 찾았을 경우 종료
                break;
            }
            //부모가 안같으면 추가
            if(find(cost[0])!=find(cost[1])){
                union(cost[0],cost[1]);
                edge++; //간선 개수 추가
                answer += cost[2];  //정답 추가
            }
        }

        return answer;
    }
}