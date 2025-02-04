import java.util.*;

class Solution {
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};
    //왼쪽, 아래, 오른쪽, 위쪽

    private static int row;
    private static int col;
    private static int[][] boards;
    private static int[][][] visited;
    private static int answer;



    //아래, 위, 왼쪽, 오른쪽

    private static class Position{
        int x;
        int y;
        int direction;
        int cost;

        public Position(int x, int y, int direction, int cost){
            this.x=x;
            this.y=y;
            this.direction = direction;
            this.cost= cost;
        }
    }


    public int solution(int[][] board) {
        row = board.length;
        col = board[0].length;
        boards = board;
        visited = new int[row][col][4];

        answer = Integer.MAX_VALUE;

        solution();

        return answer;
    }

    private static boolean isValid(int x, int y){
        return (x >= 0) && (y>=0) && (x <col) && (y<row);
    }

    private static boolean isWall(int x,int y){
        return boards[y][x] ==1;
    }

    private static int calculateCost(int i ,int cost, int direction){
        if(direction==-1 || (direction-i)%2 == 0){
            return cost + 100;
        }else{
            return cost + 600;
        }
    }

    private static boolean isShouldUpdate(int new_x,int new_y,int newCost,int i){
        return visited[new_x][new_y][i] == 0 || visited[new_x][new_y][i] > newCost;
    }

    private static void solution(){
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0,0,-1,0));

        while(!queue.isEmpty()){
            Position now = queue.poll();
            for(int i =0 ; i < 4 ; i++){
                int new_x =  now.x + dx[i];
                int new_y =  now.y + dy[i];
                if(!isValid(new_x,new_y)) continue;
                if(isWall(new_x,new_y)) continue;

                int newCost = calculateCost(i,now.cost,now.direction);

                if(new_x==col-1 && new_y ==row-1){
                    answer = Math.min(answer,newCost);
                }else if(isShouldUpdate(new_x,new_y,newCost,i)){
                    queue.add(new Position(new_x,new_y,i,newCost));
                    visited[new_x][new_y][i] = newCost;
                }


            }
        }

    }

}