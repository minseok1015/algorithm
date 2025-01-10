import java.util.*;

// 남은 일수를 먼저 계산해서 풀기 ( 사실상 큐에 대한 풀이는 아니라고 생각)

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list =new ArrayList<>();
        int[] days = new int[progresses.length];

        for(int i=0 ; i<progresses.length ; i++){
            days[i] = (int) Math.ceil((100.0- progresses[i])/speeds[i]);
        }
        int maxDay = days[0];
        int count = 0;
        for(int day : days){
            if(maxDay >= day){
                count++;
            }else{
                list.add(count);
                count=1;
                maxDay = day;
            }
        }
        list.add(count);


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}