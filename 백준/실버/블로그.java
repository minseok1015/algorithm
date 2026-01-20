import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] num  =new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum =0;
        for(int i=0;i<X;i++){
            sum+= num[i];
        }
        int count=1;

        int max = sum;
        int newSum = sum;

        for(int i=0;i<N-X;i++){
            newSum= newSum-num[i]+num[i+X];
            if(newSum>max){
                max = newSum;
                count=1;
            }else if(newSum==max){
                count++;
            }
        }

        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }



    }
}
