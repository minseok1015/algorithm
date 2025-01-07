import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] tmp = {0,0,0,0};
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<answers.length; i++){
            if(answers[i]== (p1[i%p1.length])) tmp[1]++;
            if(answers[i]== (p2[i%p2.length])) tmp[2]++;
            if(answers[i]== (p3[i%p3.length])) tmp[3]++;
        }

        int max = tmp[1];
        list.add(1);
        for(int i =1; i<tmp.length-1; i++){
            if(max<tmp[i+1]){
                list.clear();
                list.add(i+1);
                max = tmp[i+1];
            }else if(max==tmp[i+1]){
                list.add(i+1);
            }
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
