import java.util.*;

class Solution {
    public int solution(String s) {
        int answer=0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] line = s.toCharArray();
        for(int i=0;i<s.length();i++){
            boolean flag= true;
            stack.clear();
            for(int j=0; j<line.length;j++){
                if(line[(i+j)%line.length]=='['||line[(i+j)%line.length]=='{'||line[(i+j)%line.length]=='('){
                    stack.push(line[(i+j)%line.length]);
                }else if(line[(i+j)%line.length]==']'){
                    if(stack.isEmpty()||stack.pop()!='[') flag= false;
                }else if(line[(i+j)%line.length]=='}'){
                    if(stack.isEmpty()||stack.pop()!='{') flag= false;
                }else if(line[(i+j)%line.length]==')'){
                    if(stack.isEmpty()||stack.pop()!='(') flag= false;
                }
            }
            if(flag&&stack.isEmpty()) answer++;
        }
        return answer;

    }
}