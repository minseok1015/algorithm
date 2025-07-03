//https://www.acmicpc.net/problem/2805

import java.io.*;
import java.util.*;


class Main {
    private static long[] woods;
    private static int N;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        woods = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        ///////입력받기

        long start = 0;
        long end =1000000000; //int로 하면 overflow 날까?
        long mid=(start + end)/ 2;
        while(start<=end){
            mid = (start + end)/ 2;
            // System.out.println("start : " + start + ", mid : " + mid + ", end : " + end);


            long woodLength = calculateWood(mid);
            if(woodLength<M){ //M(내가 갖고 싶어하는 나무의 길이)보다 적을 때
                end = mid-1;
            }else{ //M(내가 갖고 싶어하는 나무의 길이)보다 크거나 같을 때
                start = mid+1;
            }

        }

        System.out.println(start-1);

    }

    private static long calculateWood(long cutter){
        long sum =0;
        for(int i=0; i<N; i++){
            //나무가 절단기보다 클 경우만 sum에 추가를 함. 아니면 음수가 추가될 수 있기 때문에
            if(woods[i]>cutter){
                sum += woods[i]-cutter;
            }
        }

        return sum;
    }

}
