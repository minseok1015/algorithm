import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> que1 = new ArrayDeque<>();
        ArrayDeque<String> que2 = new ArrayDeque<>();

        for(String card: cards1){
            que1.addLast(card);
        }
        for(String card: cards2){
            que2.addLast(card);
        }

        for(int i =0;i<goal.length; i++){
            String word = goal[i];
            if(word.equals(que1.peekFirst())){
                que1.pollFirst();
            }else if(word.equals(que2.peekFirst())){
                que2.pollFirst();
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}