import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list =new ArrayList<>();
        for(int n : numbers){
            list.add(String.valueOf(n));
        }

        list.sort((o1,o2)->{
            int a =Integer.parseInt(o1+o2);
            int b =Integer.parseInt(o2+o1);
            return Integer.compare(b,a);
        });

        StringBuilder sb =new StringBuilder();

        for(String num : list){
            sb.append(num);
        }

        return sb.toString().charAt(0)=='0' ? "0" : sb.toString();
    }
}