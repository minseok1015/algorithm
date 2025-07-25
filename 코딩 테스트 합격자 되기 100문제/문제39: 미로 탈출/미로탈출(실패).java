import java.util.*;

class Solution {
    private static class Node{
        int x,y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    private static ArrayDeque<Node> queue = new ArrayDeque<>();
    private static int[][] sec;
    private static char[][] map;
    private static int[] dx= {0,0,-1,1};
    private static int[] dy= {-1,1,0,0};
    //아래, 위, 왼쪽, 오른쪽 순서임
    private static int X;
    private static int Y;
    private static int lever;
    private static int answer;

    public int solution(String[] maps) {
        X = maps[0].length();
        Y = maps.length;
        sec = new int[Y][X];
        map = new char[Y][X];
        int[] start = new int[2];

        for(int i = 0 ; i <maps.length; i++){
            map[i]=maps[i].toCharArray();
            int Sindex = maps[i].indexOf("S");
            if(Sindex!=-1){
                start[0]=i; start[1]=Sindex;
            }
        }

        queue.addLast(new Node(start[0],start[1]));
        int lev[] = bfs();
        if(lever==0) return -1;
        for(int[] s: sec)Arrays.fill(s,lever);
        queue.addLast(new Node(lev[0],lev[1]));
        bfs_end(lever);
        System.out.println(lever);

        return answer==0 ? -1 : answer;
    }

    private static int[] bfs(){
        while(!queue.isEmpty()){
            Node node = queue.pollFirst();
            int x = node.x; int y= node.y;
            for(int i = 0 ; i<4;i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                //가장자리를 넘어갈 경우
                if(xx>=X || xx<0 || yy>=Y || yy< 0){
                    continue;
                }
                //벽일 경우
                if(map[xx][yy]=='X'){
                    continue;
                }
                //방문했을 경우
                if(sec[xx][yy]!=0 || map[xx][yy]=='S'){
                    continue;
                }
                sec[xx][yy] = sec[x][y]+1;
                if(map[xx][yy]=='L'){
                    lever =  sec[xx][yy];
                    return new int[]{xx,yy};
                }
                queue.addLast(new Node(xx,yy));
            }
        }
        return new int[]{-1,-1};
    }
    private static void bfs_end(int lever){
        while(!queue.isEmpty()){
            Node node = queue.pollFirst();
            int x = node.x; int y= node.y;
            for(int i = 0 ; i<4;i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                //가장자리를 넘어갈 경우
                if(xx>=X || xx<0 || yy>=Y || yy< 0){
                    continue;
                }
                //벽일 경우
                if(map[xx][yy]=='X'){
                    continue;
                }
                //방문했을 경우
                if(sec[xx][yy]!=lever){
                    continue;
                }
                sec[xx][yy] = sec[x][y]+1;
                if(map[xx][yy]=='E'){
                    answer =  sec[xx][yy];
                    break;
                }
                queue.addLast(new Node(xx,yy));
            }
        }
    }
}


/**
 1. bfs를 써서 최소거리의 레버 위치를 찾아서 감
 2. 찾아가면서 시간을 업데이트 해줌(새로운 배열 만들어서 시간값 저장)
 3. 레버 찾고서 다시 bfs를 이용해서 End위치를 찾아서 감
 **/