class Solution
{
    int answer = 1;
    public int solution(int n, int a, int b)
    {
        int person = n;
        int node = 0;
        while((n/2)!=0){
            node +=n;
            n=n/2;
        }

        node+=1;


        int a_idx = node-person+a;
        int b_idx = node-person+b;






        while(true){
            if((a_idx/2) == (b_idx/2)){
                return answer;
            }else{
                answer++;
                a_idx=a_idx/2;
                b_idx=b_idx/2;
            }
        }
    }



}