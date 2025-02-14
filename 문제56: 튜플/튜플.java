import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] input = s.split("\\},\\{");
        input[0] = input[0].substring(2);
        int inputLen = input.length;
        input[inputLen-1] = input[inputLen-1].substring(0,input[inputLen-1].length()-2);

        int[][] intArray = new int[inputLen][];
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<inputLen;i++){
            intArray[i] = Arrays.stream(input[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j<intArray[i].length;j++){
                map.put(intArray[i][j],map.getOrDefault(intArray[i][j],0)+1);
            }
        }



        return map.entrySet().stream().sorted((o1,o2)-> Integer.compare(o2.getValue(),o1.getValue())).mapToInt(entry -> entry.getKey()).toArray();
    }
}



//8자리
//9 return

