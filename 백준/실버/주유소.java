import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] price = new long[N-1];
        long[] cost = new long[N];
        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0;i<N-1;i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        st =new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int minIndex = 0;

        long sum =0;

        for(int i=0;i<N-1;i++){
            long a = sum + cost[i]*price[i];
            long b = sum + price[i] * cost[minIndex];

            // System.out.println("i : " + i + ", a : " + a + ", b : "+ b);

            if(a<b){
                minIndex = i;
                sum = a;
            }else{
                sum = b;
            }
        }

        System.out.println(sum);

    }
}
