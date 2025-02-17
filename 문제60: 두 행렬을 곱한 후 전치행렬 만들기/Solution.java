package 문제60;


import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix1_1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2_1 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        System.out.println(Arrays.deepToString(solution(matrix1_1, matrix2_1)));

        int[][] matrix1_2 = {
                {2, 4, 6},
                {1, 3, 5},
                {7, 8, 9}
        };
        int[][] matrix2_2 = {
                {9, 1, 2},
                {4, 5, 6},
                {7, 3, 8}
        };
        System.out.println(Arrays.deepToString(solution(matrix1_2, matrix2_2)));
    }





    // 이 부분을 변경해서 실행해보세요.
    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] multipledMatrix = multiple(matrix1,matrix2);

        int[][] translatedMatrix  = tanslate(multipledMatrix);

        return translatedMatrix;
    }

    private static int[][] multiple(int[][] matrix1, int[][] matrix2){
        int a = matrix1.length;
        int b = matrix2.length;
        int c = matrix2[0].length;

        int[][] temp = new int[a][c];

        for(int i =0 ; i<a; i++){
            for(int j = 0 ; j<c;j++){
                for(int k =0; k<b ;k++){
                    temp[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return temp;

    }

    private static int[][] tanslate(int[][] matrix){
        int[][] temp = new int[matrix.length][matrix[0].length];

        for(int i =0 ; i<temp.length;i++){
            for(int j = 0 ; j<temp[0].length;j++){
                temp[j][i]= matrix[i][j];
            }
        }

        return temp;

    }

}