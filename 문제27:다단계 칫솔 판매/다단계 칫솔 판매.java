import java.util.*;

class Solution {
    HashMap<String, Integer> profitMap = new HashMap<>();
    HashMap<String, String> refMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        for(int i = 0 ; i<enroll.length; i++){
            refMap.put(enroll[i],referral[i]);
            profitMap.put(enroll[i],0);
        }



        for(int i = 0; i<seller.length;i++){
            int profit = amount[i] * 100;
            cal(seller[i],profit);
        }

        int[] answer = new int[enroll.length];
        for(int i = 0 ; i<enroll.length;i++){
            answer[i]= profitMap.get(enroll[i]);
        }
        return answer;

    }

    public void cal(String seller, int amount){
        if(amount<1 || seller.equals("-")){
            return;
        }

        int charge =  amount/10;
        int mySelf = amount - charge;

        profitMap.put(seller,profitMap.get(seller)+ mySelf);

        cal(refMap.get(seller), charge);
    }
}