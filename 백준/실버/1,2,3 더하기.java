import java.io.*;

class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[12];
        list[1] = 1;
        list[2] = 2;
        list[3] = 4;
        for(int i=4;i<=11;i++){
            list[i] = list[i-1]+list[i-2]+list[i-3];
        }


        for(int i=0;i<N;i++){
            int number = Integer.parseInt(br.readLine());
            System.out.println(list[number]);

        }

    }
}
