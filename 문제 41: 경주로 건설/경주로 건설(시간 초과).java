class Solution {
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static int row;
    private static int col;
    private static int[][] borards;
    private static boolean[][] visited;

    private static long min = Long.MAX_VALUE;


    //아래, 위, 왼쪽, 오른쪽

    private static class Position{
        int x;
        int y;

        public Position(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    public int solution(int[][] board) {
        row = board.length;
        col = board[0].length;
        borards = board;
        visited = new boolean[row][col];
        visited[0][0] =true;


        dfs(0,false,new Position(0,0));
        dfs(0,true,new Position(0,0));


        return (int)min;
    }

    // ax -> true면 가로, false면 세로
    private static void dfs(int cost, boolean ax, Position position){
        if(position.x == col-1 && position.y ==row-1){
            min = Math.min(cost, min);
        }

        for(int i = 0 ;  i <4 ; i++){

            int xx = position.x + dx[i];
            int yy = position.y + dy[i];

            if(xx<0 || yy<0 || xx>=col || yy>=row){//보드를 벗어날 경우
                continue;
            }
            if(borards[yy][xx]==1){ //벽인 경우
                continue;
            }
            if(visited[yy][xx]){
                continue;
            }
            visited[yy][xx] =true;


            boolean isHorizontalMove = (dx[i] != 0); // 현재 움직임이 가로인지 여부
            if (ax == isHorizontalMove) { // 같은 방향 유지
                dfs(cost + 100, isHorizontalMove, new Position(xx, yy));
            } else { // 방향 전환
                dfs(cost + 600, isHorizontalMove, new Position(xx, yy));
            }

            visited[yy][xx] =false;

        }

    }

}