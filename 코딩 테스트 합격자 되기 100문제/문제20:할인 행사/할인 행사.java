import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        int m=0;
        HashMap<String,Integer> wantMap = new HashMap<>();
        for(int i = 0 ; i < n; i ++){
            wantMap.put(want[i],number[i]);
            m+=number[i];
        }
        for(int i =0; i< discount.length -9 ;i++){
            HashMap<String,Integer> disMap = new HashMap<>();
            for(int j = i ; j< i +10 ; j++){
                disMap.put(discount[j], disMap.getOrDefault(discount[j],0)+1);
            }
            if(wantMap.equals(disMap)){
                answer++;
            }
        }
        return answer;

    }
}