import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set =new HashSet<>();
        char lastChar = '-';

        for(int i = 0 ; i<words.length; i++){
            String word = words[i];
            if(set.contains(word)){
                return new int[]{(i%n)+1,(i/n)+1};
            }

            char[] w = word.toCharArray();


            if(w[0]!=lastChar && i!=0){
                return new int[]{(i%n)+1,(i/n)+1};
            }
            lastChar = w[w.length-1];
            set.add(word);
            System.out.println(word);
        }

        return new int[]{0,0};
    }
}