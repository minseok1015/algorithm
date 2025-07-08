import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] wheels = new int[4][8];

        //톱니바퀴 입력받기
        for(int i = 0 ; i<4;i++){
            String input = br.readLine();
            for(int j=0; j<8;j++){
                wheels[i][j] = input.charAt(j)-'0';
            }
        }

        //회전수와 방향 입력받기
        int K = Integer.parseInt(br.readLine());
        int[][] rotate = new int[K][2];

        for(int i =0 ; i<K;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            rotate[i][0] = Integer.parseInt(st.nextToken());
            rotate[i][1] = Integer.parseInt(st.nextToken());
        }


        //K번 만큼 반복
        for(int i=0;i<K;i++){
            int startWheel = rotate[i][0];  //3
            int startRotate = rotate[i][1]; //-1
        }

        //1.회전시켜야할 톱니들 구함
        //2.회전
        //3.반복



    }
}
