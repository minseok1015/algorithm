import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int width = w;
        int height = (n+w-1)/w;
        int[][] box = new int[height][width]; // 0 : 비어있음


        boolean direct = true;
        int number = 1;
        for(int i=height-1; i>=0 ;i--){
            for(int j=0;j<width;j++){
                if(number>n){
                    break;
                }
                if(direct){
                    box[i][j] = number++;
                }else{
                    box[i][width-j-1] = number++;
                }
            }
            direct = !direct;
        }
        int answer=0;

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(box[i][j]==num){
                    answer= i;
                    if(box[0][j]>0){
                        answer++;
                    }
                }
            }
        }

        return answer;

    }
}