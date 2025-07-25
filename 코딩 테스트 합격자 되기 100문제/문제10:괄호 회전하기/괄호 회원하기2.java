import java.util.*;

class Solution {
    public int solution(String s) {
        int answer=0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        char[] line = s.toCharArray();
        A:for(int i=0;i<s.length();i++){
            boolean flag= true;
            stack.clear();
            for(int j=0; j<line.length;j++){
                int n= (i+j)% line.length;
                if(!map.containsKey(line[n])){
                    stack.push(line[n]);
                }else{
                    if(stack.isEmpty()||stack.pop()!=map.get(line[n])){
                        continue A;
                    }
                }
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;

    }
}