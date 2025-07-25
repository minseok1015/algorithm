class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int location=1;
        int index=0;

        while(location<=n){

            //기지국이 설치 안된 곳인 경우
            if(index>= stations.length || stations[index]-w>location){
                location=location+2*w+1;
                count++;
            }else{
                location=stations[index]+w+1;
                index++;
            }
        }



        return count;
    }
}