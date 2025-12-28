import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int stage = 1;

        N = N-1;

        if(N==0){
            System.out.println(1);
        }else{
            while(N>0){
                N = N - stage*6;
                stage++;
            }

            System.out.println(stage);
        }

    }
}
