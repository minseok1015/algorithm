import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Row = arr2.length;
        int arr2Col = arr2[0].length;

        int[][] answer = new int[arr1Row][arr2Col];

        for(int i = 0 ; i < arr1Row;i++){ //행 순서대로
            for(int j = 0 ; j< arr2Col ; j++){
                for(int k = 0; k < arr1Col; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}

/*
1. 두 행렬의 행과 열을 저장한다.
2. 행 순서대로 계산을 한다(1행 1열, 1행 2열..., 2행 1열, 2행 1열...)
3.
*/