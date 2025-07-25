import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = moves.length; //게임 시행 횟수;
        ArrayDeque<Integer> stack = new ArrayDeque<>(); //스택 선언
        int answer = 0;

        A:for(int i=0;i<n;i++){
            int m = moves[i]-1;
            int boardLength = board.length;
            for(int j = 0; j < boardLength; j++){
                if(board[j][m]!=0){
                    int select = board[j][m];
                    board[j][m]=0;
                    if(!stack.isEmpty() && stack.peek()==select){
                        stack.pop();
                        answer++;
                        answer++;
                    }else{
                        stack.push(select);
                    }
                    continue A;
                }
            }
        }

        return answer;
    }


}
