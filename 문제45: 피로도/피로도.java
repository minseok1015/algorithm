

class Solution {

    private static boolean visited[];
    private static int dunLen;
    private static int[][] dun;
    private static int answer;

    public int solution(int k, int[][] dungeons) {

        dunLen =dungeons.length;
        dun = dungeons;
        visited = new boolean[dunLen];

        answer = 0;

        for(int i = 0 ; i<dunLen; i++){
            visited[i] = true;
            backTracking(i,0,k-dun[i][0],k-dun[i][1]);
            visited[i] = false;
        }


        return answer;
    }

    private static void backTracking(int index,int count,int tired,int tiredness){
        if(tired<0){
            answer = Math.max(answer,count);
            return;
        }
        if(count==dunLen-1){
            answer = dunLen;
            return;
        }

        for(int i = 0 ; i<dunLen ; i++){
            if(visited[i]) continue;
            visited[i] = true;
            backTracking(i,count+1,tiredness-dun[i][0],tiredness-dun[i][1]);
            visited[i] = false;
        }

    }
}