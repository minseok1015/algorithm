

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/18808


//1. 먼저 입력받음
//2. 왼쪽 위부터 오른쪽 아래까지 시뮬레이션을 돌리다가 안되는 부분 있으면 return(이미 노트북에 모눈종이가 채워져있는 영역을 만났다는 말)
//2-1. 회전시킴. 90도씩 네번
//3. 2번을 통과했으면(모눈종이가 들어갈 영역이 있다는 것을 확인) 노트북에 모눈종이를 채워 넣어줌
//4. 순서대로 진행한 후 노트북에서 채워진 부분을 세면됨.



class Main {

    private static int[][] notebook;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        int K = Integer.parseInt(st.nextToken()); //스티커의 갯수

        notebook= new int[N][M];


        for(int i = 0 ; i<K ; i++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()); //모눈 종이의 행
            int C = Integer.parseInt(st.nextToken()); //모눈 종이의 열

            int[][] board = inputBoard(R,C,br); //모눈종이 입력받기

            for(int j=0;j<4;j++){//방향 바꾸면서 simulate
                if(simulate(board)) break;
                // System.out.println("방향 바꾸기");
                board = roateBoard(board);

            }

        }

        System.out.println(calculateAnswer());

    }

    //모눈종이 입력받기
    private static int[][] inputBoard(int row, int col,BufferedReader br)throws IOException{

        // System.out.println("모눈종이 입력받기!");
        int[][] board = new int[row][col];
        for(int i=0;i<row;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return board;
    }

    //모눈종이 들어갈 수 있는지 확인
    private static boolean checkBoard(int[][] board,int row,int col){
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                // System.out.println("i : "+i+", j : " +j+", row+i : "+ (row+i) + ", col+j : " + (col+j));
                if(board[i][j]==1&&notebook[row+i][col+j]==1){//둘다 차있는 경우(넣을 수 없음)
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean simulate(int[][] board){
        int noteRow = notebook.length;
        int noteCol = notebook[0].length;
        int boardRow = board.length;
        int boardCol = board[0].length;
        // System.out.println("boardRow : "+ boardRow + ", boardCol : "+ boardCol);
        // System.out.println("noteRow : "+ noteRow + ", noteCol : "+ noteCol);

        int check=0;
        // System.out.println("noteCol-boardCol : " + (noteCol-boardCol));
        for(int i =0 ; i<=(noteRow-boardRow)  ; i++){
            for(int j =0; j<=(noteCol-boardCol);j++){
                // System.out.println("check : "+ check++);
                if(checkBoard(board,i,j)){ //모눈종이가 들어갈 수 있으면
                    //보드 채우기
                    // System.out.println("모눈종이를 노트북에 채워넣습니다!");
                    fillnote(board,i,j);
                    return true;
                }
            }
        }
        return false;

    }

    //notebook에 붙이기
    private static void fillnote(int[][] board,int row, int col){
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j]==1){
                    notebook[row+i][col+j]=1;
                }
            }
        }

        // for(int i =0;i<notebook.length;i++){
        //   for(int j =0;j<notebook[0].length;j++){
        //     System.out.print(notebook[i][j]);
        //   }
        //   System.out.println();
        // }
    }

    //모눈종이 각도 돌리기
    private static int[][] roateBoard(int[][] board){
        int row = board.length;
        int col = board[0].length;
        int[][] rotatedBoard = new int[col][row];

        for(int i=0;i<row;i++){
            for(int j=0; j<col;j++){
                rotatedBoard[j][row-i-1] = board[i][j];
            }
        }
        return rotatedBoard;
    }


    private static int calculateAnswer(){
        int answer=0;
        for(int i =0;i<notebook.length;i++){
            for(int j =0; j<notebook[0].length;j++){
                if(notebook[i][j]==1){
                    answer++;
                }
            }
        }
        return answer;
    }

}


