import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        Schedule[] schedule = new Schedule[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            schedule[i]= new Schedule(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int[] dp =new int[N+2];
        for(int i=1;i<=N;i++){
            dp[i] = Math.max(dp[i-1],dp[i]);

            if(schedule[i].day+i-1 <=N){
                dp[schedule[i].day+i-1] = Math.max(dp[schedule[i].day+i-1],dp[i-1]+schedule[i].time);
            }



        }

        System.out.println(dp[N]);


    }

    static class Schedule{
        int day;
        int time;

        public Schedule(int day,int time){
            this.day =day;
            this.time = time;
        }
    }
}
