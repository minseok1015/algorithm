import java.util.*;
import java.io.*;


class Main {

    // private static boolean[][] visited = new boolean[9][9];
    private static int[][] board;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];

        for(int i=0;i<9;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] =  Integer.parseInt(st.nextToken());
            }
        }


        back(0,0);

    }

    private static void back(int row, int col){
        if(col==9){
            back(row+1,0);
            return;
        }

        if(row==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if(board[row][col]==0){
            for(int i=1;i<=9;i++){
                if(isPosible(row,col,i)){
                    board[row][col] = i;
                    back(row,col+1);
                }
            }
            board[row][col] = 0;
            return;
        }

        back(row,col+1);


    }

    private static boolean isPosible(int row,int col , int value){
        for(int i=0;i<9;i++){
            if(board[row][i]==value){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(board[i][col]==value){
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for(int i=set_row;i<set_row+3;i++){
            for(int j=set_col;j<set_col+3;j++){
                if(board[i][j]==value){
                    return false;
                }
            }
        }

        return true;
    }




}
