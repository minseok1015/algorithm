import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n+2];
        int[] down = new int[n+2];

        for(int i =0 ;i< n+2;i++){
            up[i] = i-1;
            down[i] = i+1;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        k++;

        for(String c : cmd){
            if(c.startsWith("C")){ //삭제
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                stack.push(k);
                if(down[k]>n){
                    k=up[k];
                }else{
                    k=down[k];
                }
            }
            else if(c.startsWith("Z")){ //복구
                int restore= stack.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            else{ //이동
                String[] str = c.split(" ");
                int distance = Integer.parseInt(str[1]);

                for(int i=0;i< distance ;i ++){
                    k= str[0].equals("U") ? up[k] : down[k];
                }
            }

        }
        StringBuilder sb = new StringBuilder("O".repeat(n));

        while(!stack.isEmpty()){
            int a = stack.pop();

            sb.setCharAt(a-1,'X');
        }

        return sb.toString();

    }
}
