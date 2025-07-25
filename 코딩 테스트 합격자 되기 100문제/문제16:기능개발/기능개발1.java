import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> waitList = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();


        for(int i =0;i<progresses.length; i++){
            que.addLast(i);
        }
        while(!que.isEmpty()){
            for(int i =0; i<progresses.length;i++){
                if(progresses[i]<100){
                    progresses[i]+=speeds[i];
                }
                if(progresses[i]>=100){
                    waitList.add(i);
                }
            }
            int count=0;
            while(waitList.contains(que.peekFirst())){
                que.pollFirst();
                count++;
                if(!waitList.contains(que.peekFirst())){
                    answer.add(count);
                }
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
