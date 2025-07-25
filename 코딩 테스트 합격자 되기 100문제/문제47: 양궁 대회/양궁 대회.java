import java.util.*;

class Solution {
    private static int[] apeach = new int[11];
    private static int max = 0;
    private static int[] answer = {-1};
    private static int N;


    public int[] solution(int n, int[] info) {
        apeach = info;
        N = n;
        dfs(n,0,new int[11]);


        return answer;
    }

    private static void dfs(int n,int idx,int[] lion){
        if(n==0){
            calculateDiff(lion);
            return;
        }

        for(int i=idx ; i<= 10 ;i++){
            int cnt = Math.min(n,apeach[i]+1);
            lion[i] = cnt;
            dfs(n-cnt, i+1 ,lion);
            lion[i] = 0;
        }

    }

    private static void calculateDiff(int[] lion){
        int lionScore = 0;
        int apeachScore = 0;
        for(int i =0 ; i<=10;i++){
            if(lion[i]+apeach[i]==0){
                continue;
            }
            if(lion[i]>apeach[i]){
                lionScore+= 10-i;
            }else{
                apeachScore+= 10-i;
            }
        }

        int score = lionScore -apeachScore;
        if(score>max){
            max = score;
            answer= lion.clone();
        }else if(max>0&& score==max){
            for(int i =10;i>=0;i--){
                if(answer[i]!=lion[i]){
                    if(answer[i]<lion[i]){
                        answer= lion.clone();
                    }
                    break;
                }
            }
        }
    }


}


//주의 : 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.

