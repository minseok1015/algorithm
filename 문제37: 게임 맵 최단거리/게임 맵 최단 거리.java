import java.util.*;

class Solution {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    //왼쪽, 오른쪽, 아래, 위 순서임


    public static class Node{
        int n,m;

        public Node(int n, int m){
            this.n=n;
            this.m=m;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length;

        int[][] dist = new int[N][M];
        //방문 길이 저장할 배열

        ArrayDeque<Node> que = new ArrayDeque<>();
        que.addLast(new Node(0,0));
        dist[0][0] = 1;

        while(!que.isEmpty()){
            Node now= que.pollFirst();

            for(int i = 0 ; i<4 ;i++){
                int dn = now.n + dx[i];
                int dm = now.m + dy[i];

                if(dn<0 || dn>=N || dm<0 || dm>=M)
                    continue;
                if(maps[dn][dm]==0)
                    continue;
                if(dist[dn][dm]==0){
                    que.addLast(new Node(dn,dm));
                    dist[dn][dm] = dist[now.n][now.m]+1;
                }
            }
        }

        return dist[N-1][M-1]==0 ? -1 : dist[N-1][M-1];
    }
}