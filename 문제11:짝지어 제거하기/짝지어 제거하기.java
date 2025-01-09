import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer=0;
        ArrayList<Character> str = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            str.add(s.charAt(i));
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<str.size();i++){
            if(stack.isEmpty()||stack.peek()!=str.get(i)){
                stack.push(str.get(i));
            }else{
                stack.pop();

            }
        }

        if(stack.isEmpty()){
            answer=1;
        }

        return answer;
    }
}