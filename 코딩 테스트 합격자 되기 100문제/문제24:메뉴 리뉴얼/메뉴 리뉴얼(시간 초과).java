import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashSet<String> answer = new HashSet<>();

        for(int i = 0 ; i<orders.length;  i++){
            String order = orders[i];
            int n = order.length();
            HashSet<Character> set = new HashSet<>();
            for(int j =0 ; j<n; j++){
                set.add(order.charAt(j));
            }
            for(int k = i+1; k<orders.length;i++){
                String s=orders[k];
                StringBuilder sb= new StringBuilder();
                for(int m =0 ; m<s.length();m++){
                    if(set.contains(s.charAt(m))){
                        sb.append(s.charAt(m));
                    }
                }
                if(sb.length()>=2){
                    answer.add(sb.toString());
                }
            }
        }

        return answer.stream().sorted().toArray(String[]::new);


    }
}