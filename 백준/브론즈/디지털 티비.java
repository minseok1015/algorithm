import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] channel = new String[N];

        for(int i=0;i<N;i++){
            channel[i] = br.readLine();
        }



        StringBuilder sb= new StringBuilder();

        //KBS1 찾기
        for(int i=0;i<N;i++){
            if(channel[i].equals("KBS1")){
                //올리기
                for(int j=0;j<i;j++){
                    String temp = channel[i-j];
                    channel[i-j] = channel[i-j-1];
                    channel[i-j-1] = temp;
                    sb.append("4");
                }
                break;
            }
            //아래로 이동
            sb.append("1");
        }

        // System.out.println();
        // for(int i=0;i<N;i++){
        //   System.out.println(channel[i]);
        // }

        //KBS2 찾기
        for(int i=0;i<N;i++){
            if(channel[i].equals("KBS2")){
                //올리기
                for(int j=0;j<i-1;j++){
                    String temp = channel[i-j];
                    channel[i-j] = channel[i-j-1];
                    channel[i-j-1] = temp;
                    sb.append("4");
                }
                break;
            }
            //아래로 이동
            sb.append("1");
        }

        // System.out.println();
        // for(int i=0;i<N;i++){
        //   System.out.println(channel[i]);
        // }

        System.out.println(sb.toString());

        //11144411144

    }
}
