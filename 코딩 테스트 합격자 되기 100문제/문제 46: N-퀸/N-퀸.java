class Solution {
    private static int N;
    private static boolean[] dialog1;
    private static boolean[] dialog2;
    private static boolean[] width;


    public int solution(int n) {
        N = n;
        width = new boolean[n];
        dialog1 = new boolean[n*2];
        dialog2 = new boolean[n*2];



        return queen(0);
    }

    private static int queen(int row){
        int answer= 0 ;

        if(row==N){
            answer++;
        }else{
            for(int i = 0 ; i<N ; i++){
                if(width[i] || dialog1[i+row] || dialog2[i-row+N]) continue;
                width[i] = true;
                dialog1[i+row] =true;
                dialog2[i-row+N]= true;
                answer+=queen(row+1);
                width[i] = false;
                dialog1[i+row] =false;
                dialog2[i-row+N]= false;
            }
        }
        return answer;

    }





}