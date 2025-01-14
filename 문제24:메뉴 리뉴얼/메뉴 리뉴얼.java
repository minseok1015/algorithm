import java.util.*;
import java.util.stream.*;

class Solution {
    HashMap<Integer, HashMap<String,Integer>> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for(int c: course){
            map.put(c,new HashMap<>());
        }

        ArrayList<String> answer = new ArrayList<>();

        for(String order : orders){
            char[] o = order.toCharArray();
            Arrays.sort(o);
            combination(0,o,"");
        }

        for (HashMap<String, Integer> count : map.values()) {
            count.entrySet().stream()
                    .max((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))
                    .ifPresent(entry-> count.entrySet().stream().filter(e-> e.getValue().equals(entry.getValue())&&e.getValue()>1).forEach(a-> answer.add(a.getKey()))
                    );
        }




        return answer.stream().sorted().toArray(String[]::new);

    }


    public void combination(int idx, char[] orderArray, String result){
        if(map.containsKey(result.length())){
            map.get(result.length()).put(result,map.get(result.length()).getOrDefault(result,0)+1);
        }

        for(int i = idx;i<orderArray.length;i++){
            combination(i+1,orderArray,result+orderArray[i]);
        }
    }

}