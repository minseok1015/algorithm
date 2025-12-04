import java.util.*;
import java.io.*;

class Main {
    private static int N;
    private static int M;


    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        //H, W, N, M
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        long h = (H+N) / (N+1);
        long w = (W+M) / (M+1);
        if(h==0){
            h=1;
        }
        if(w==0){
            w=1;
        }

        long answer = h*w;

        System.out.println(answer);


    }
}
