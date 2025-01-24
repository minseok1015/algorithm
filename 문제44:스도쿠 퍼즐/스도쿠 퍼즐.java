package 문제44번;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] board1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(Arrays.deepToString(solution(board1)));

        int[][] board2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.deepToString(solution(board2)));
    }

    private static int[][] boards;

    private static class Position{
        int row,col;

        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static Position findEmptyPosition(){
        for(int i = 0 ; i<9 ; i++){
            for(int j = 0 ; j <9 ; j++){
                if(boards[i][j]==0){
                    return new Position(i,j);
                }
            }
        }
        return null;
    }


    private static boolean isValid(int num, int row, int col){
        return isValidRow(row,num) && isValidCol(col,num) && isValidSet(row,col,num);
    }

    private static boolean isValidRow(int row,int num){
        for(int i=0; i<9;i++) {
            if (boards[row][i] == num) {//같은 숫자가 있으면 숫자가 못 들어가니까 false;
                return false;
            }
        }
        return true;//같은 숫자가 없었으므로 true;
    }

    private static boolean isValidCol(int col,int num){
        for(int i=0; i<9;i++) {
            if (boards[i][col] == num) {//같은 숫자가 있으면 숫자가 못 들어가니까 false;
                return false;
            }
        }
        return true;//같은 숫자가 없었으므로 true;
    }

    private static boolean isValidSet(int row, int col, int num){
        int setRow = (row/3) *3;
        int setCol = (col/3) *3;

        for(int i = setRow ; i< setRow+3;i++){
            for(int j = setCol ; j < setCol+3 ;j++){
                if(boards[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean findSolution(){
        Position pos = findEmptyPosition();
        if(pos ==null){
            return true;
        }

        int row = pos.row;
        int col = pos.col;

        for(int i = 1 ; i<=9 ; i++){
            if(isValid(i,row,col)){
                boards[row][col]=i;
                if(findSolution()){
                    return true;
                }
                boards[row][col]=0;
            }
        }

        return false;
    }



    private static int[][] solution(int[][] board) {
        boards= board;
        findSolution();
        return board;
    }

}