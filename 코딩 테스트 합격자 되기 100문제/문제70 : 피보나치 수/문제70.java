class Solution {
    public int solution(int n) {
        long[] list = new long[n+1];
        list[0]=0;
        list[1]=1;


        for(int i=2;i<=n;i++){
            list[i]=(list[i-1]%1234567+list[i-2]%1234567)%1234567;

        }

        return (int) list[n]%1234567;

    }
}