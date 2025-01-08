class Solution {
    public int solution(String dirs) {
        int[][] x = new int[10][11];
        int[][] y = new int[11][10];

        int xp=5;
        int yp=5;

        int answer = 0;

        char[] commands=dirs.toCharArray();
        int tmp=0;

        for(int i = 0; i<commands.length ; i++){
            char command = commands[i];
            if(command=='U'){
                if(yp==10) continue;
                tmp = y[xp][yp];
                y[xp][yp]=1;
                yp++;
            }
            if(command=='D'){
                if(yp==0) continue;
                tmp = y[xp][yp-1];
                y[xp][yp-1]=1;
                yp--;
            }
            if(command=='R'){
                if(xp==10) continue;
                tmp = x[xp][yp];
                x[xp][yp]=1;
                xp++;
            }
            if(command=='L'){
                if(xp==0) continue;
                tmp = x[xp-1][yp];
                x[xp-1][yp]=1;
                xp--;
            }

            if(tmp!=1){
                answer++;
            }

        }

        return answer;
    }
}