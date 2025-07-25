class Solution {
    public int solution(int n) {
        long[] list = new long[n+1];
        list[1]=1;
        list[2]=2;

        for(int i=3;i<=n;i++){
            list[i] = (list[i-1]+list[i-2])%1000000007;
        }

        return (int) list[n];
    }
}