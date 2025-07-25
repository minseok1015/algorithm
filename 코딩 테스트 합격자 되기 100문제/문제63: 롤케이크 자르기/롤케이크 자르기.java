import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashSet<Integer> rightSet = new HashSet<>();
        HashSet<Integer> leftSet = new HashSet<>();
        int[] toppingCount = new int[10001];
        for(int t : topping){
            rightSet.add(t);
            toppingCount[t]++;
        }

        int count = rightSet.size();


        int result=0;

        for(int t: topping){
            leftSet.add(t);
            toppingCount[t]--;
            if(toppingCount[t]==0){
                count--;
            }
            if(count==leftSet.size()) result++;
        }

        return result;
    }
}