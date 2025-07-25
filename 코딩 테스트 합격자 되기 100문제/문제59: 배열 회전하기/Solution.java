package 문제59;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n1 = 1;
        System.out.println(Arrays.deepToString(solution(arr1, n1)));
        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n2 = 2;
        System.out.println(Arrays.deepToString(solution(arr2, n2)));
    }



    // 이 부분을 변경해서 실행해보세요.
    private static int[][] solution(int[][] arr, int n) {
        int[][] arr2 = rotate(arr,n);

        return arr2;

    }

    private static int[][] rotate(int[][] arr,int n){
        if(n==0) return arr;

        int size = arr.length;
        int[][] arr2 = new int[size][size];
        for(int i = 0 ; i<size;i++){
            for(int j =0;j<size;j++){
                arr2[j][size-1-i] = arr[i][j];
            }
        }

        return rotate(arr2,n-1);
    }

}