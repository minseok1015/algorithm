import java.io.*;
import java.util.*;

class Main {
    private static int[] times;
    private static int M;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];

        int max=0;

        for(int i =0 ; i<N; i++){
            times[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, times[i]);
        }

        long start =0;
        long end = (long)max * M;


        while(start<=end){
            long mid = (start+end) / 2;

            // System.out.println("mid : " + mid + ", simulate : " + simulate(mid));
            if(simulate(mid)>=M){
                end = mid-1;
            }else{
                start =mid+1;
            }

        }

        System.out.println(start);

    }

    private static long simulate(long mid){
        long sum=0;

        for(int time : times){
            sum+= mid/time;
            if(sum>=M) break; //이 부분이 중요!
        }

        return sum;
    }
}


/** overflow에 조심하자
 10억 시간이 소요되는 창구, 1 시간이 소요되는 창구가 9999만개의 창구가 있다고 생각해보자
 그리고 사람은 10억명이 있다고 쳐보자

 end값은 최댓값인 10억*10억이 될 것이고
 mid값은 10억 * 5억이 될 것이다.
 이 상태로 simulate함수를 돌리게 되면

 sum += 10억 * 5억 /1 의 연산이 9999만번 발생해서 overflow가 발생하게 된다.



 **/