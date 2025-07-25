import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty()||stack.pop()==')') return false;
            }

        }
        return stack.isEmpty();
    }
}