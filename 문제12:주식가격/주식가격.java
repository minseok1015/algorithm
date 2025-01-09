import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()] ){ //스택이 비어있으면 while문 나감
                answer[stack.peek()]= i-stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.peek()]=n-1-stack.pop();
        }

        return answer;
    }
}