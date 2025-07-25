public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(2));
        System.out.println(solution(7));
    }
    private static ArrayList<ArrayList<Integer>> result =new ArrayList<>();
    private static int n ;


    private static ArrayList<ArrayList<Integer>> solution(int N) {
        n=N;
        backtracking(0,new ArrayList<>(),1);

        return result;
    }

    private static void backtracking(int sum,ArrayList<Integer> selectedNums, int start){

        //합이 10인 경우 추가
        if(sum==10){
            result.add(selectedNums);
            return;
        }

        for(int i=start ; i<=n ; i++){
            if(sum + i <= 10){
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtracking(sum+i,list,i+1);
            }
        }
    }

}