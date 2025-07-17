import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123)));
        System.out.println(Arrays.toString(solution(350)));
    }

    private static int[] solution(int amount) {

        int[] coins = {1,10,50,100};

        ArrayList<Integer> answer =new ArrayList<>();

        int point = 3;

        while(amount>0){
            if(amount-coins[point]>=0){
                amount = amount-coins[point];
                answer.add(coins[point]);
                // System.out.println("추가 : " + coins[point] + ", 남은 금액 :" + amount);
            }else{
                point--;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}