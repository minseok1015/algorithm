import java.util.*;


//30,50,50,70

// (30,50),(50),(70)

// (70,30) (50,50)

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        int i=0;
        int j=people.length-1;

        Arrays.sort(people);

        while(i<=j){
            if((people[i]+people[j])<=limit){
                i++;
            }

            j--;
            answer++;
        }


        return answer;
    }
}