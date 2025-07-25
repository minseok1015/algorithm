import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }

        list.sort((o1,o2)->{
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return b-a;
        });

        StringBuilder sb = new StringBuilder();

        for(String l : list){
            sb.append(l);
        }


        return sb.toString();


    }
}