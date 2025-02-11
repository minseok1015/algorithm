import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length];
        int n=0;
        for(int[] com : commands){
            int[] arr = new int[com[1]-com[0]+1];
            for(int i=0;i<arr.length;i++){
                arr[i]=array[com[0]-1+i];
            }
            Arrays.sort(arr);
            answer[n]=arr[com[2]-1];
            n++;
        }
        return answer;
    }
}