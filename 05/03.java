import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i < numbers.length ; i++){
            for(int j = i+1; j < numbers.length ; j++){
                result.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = result.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}