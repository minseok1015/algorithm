import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer =0;
        ArrayDeque<Server> queue = new ArrayDeque<>();

        for(int i=0;i<24;i++){
            while(!queue.isEmpty() &&(queue.peek().time+k <= i) ){
                queue.pop();
            }

            while(queue.size()*m+m <= players[i]){ //서버의 증설이 필요한 경우, 반복하면서 증설
                queue.add(new Server(i));
                answer++;
            }
        }

        return answer;

    }

    class Server{
        int time;

        public Server(int time){
            this.time = time;
        }

    }
}