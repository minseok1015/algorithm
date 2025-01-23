import java.util.*;

class Solution {
    private static class Point{
        int x,y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    private static char[][] map;

    private static int[] dx= {0,0,-1,1};
    private static int[] dy= {-1,1,0,0};
    //아래, 위, 왼쪽, 오른쪽 순서임
    private static int N,M;

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        for(int i =0;i<N;i++){
            map[i]=maps[i].toCharArray();
        }

        Point start=null,end=null,lever=null;

        for(int i = 0 ; i< N ; i++){
            for(int j= 0 ; j < M ;j++){
                if(map[i][j]=='S') start = new Point(j,i);
                else if(map[i][j]=='L') lever = new Point(j,i);
                else if(map[i][j]=='E') end = new Point(j,i);
            }
        }

        int startToLever = bfs(start,lever);
        System.out.println("startToLever: "+ startToLever);
        int LeverToStart = bfs(lever,end);
        System.out.println("LeverToStart: "+ LeverToStart);

        if(startToLever==-1 || LeverToStart==-1){
            return -1;
        }else{
            return startToLever + LeverToStart;
        }
    }

    private static int bfs(Point start, Point end){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int[][] sec = new int[N][M];
        sec[start.y][start.x] =1;
        queue.add(start);

        while(!queue.isEmpty()){
            Point now = queue.poll();
            System.out.println("x :"+now.x+",y : "+now.y);
            for(int i =0; i<4 ;i++){
                int xx= now.x + dx[i];
                int yy= now.y + dy[i];

                //벽을 넘어가는 경우
                if(xx<0 || xx>=M || yy< 0 || yy>=N){
                    continue;
                }
                //방문한 경우
                if(sec[yy][xx]>0){
                    continue;
                }
                //통로가 아닌경우
                if(map[yy][xx]=='X'){
                    continue;
                }

                sec[yy][xx] = sec[now.y][now.x]+1;
                queue.add(new Point(xx,yy));

                if(xx==end.x && yy == end.y){
                    return sec[yy][xx]-1;
                }
            }
        }
        return -1;
    }

}


/**
 1. bfs를 써서 최소거리의 레버 위치를 찾아서 감
 2. 찾아가면서 시간을 업데이트 해줌(새로운 배열 만들어서 시간값 저장)
 3. 레버 찾고서 다시 bfs를 이용해서 End위치를 찾아서 감
 **/