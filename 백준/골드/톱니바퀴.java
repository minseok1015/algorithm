import java.util.*;
import java.io.*;

class Main {
    private static int[][] wheels = new int[5][8];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //톱니바퀴 입력받기
        for(int i = 1 ; i<=4;i++){
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

            int[] rotateWheel = new int[5];
            boolean[] visited = new boolean[5];
            rotateWheel[startWheel] = startRotate;

            //1.회전시켜야할 톱니들 구함
            rotateCheck(rotateWheel,startWheel,visited);
            // System.out.print("rotaeWheel: ");
            // for(int j=1;j<=4;j++){
            //   System.out.print(rotateWheel[j]);
            // }
            // System.out.println();

            //2.회전
            rotate(rotateWheel);

            // System.out.println(i + "번째 출력");
            // for(int j=1;j<=4;j++){
            //   for(int k=0;k<8;k++){
            //     System.out.print(wheels[j][k]);
            //   }
            //   System.out.println();
            // }
        }


        int answer=0;
        for(int i = 1; i<=4;i++){
            if(wheels[i][0]==1){
                answer += Math.pow(2,i-1);
            }
        }

        System.out.println(answer);



    }

    private static void rotateCheck(int[] rotateWheel,int wheel,boolean[] visited){
        int[] updown = new int[]{-1,1};
        visited[wheel] = true;

        for(int i=0;i<2;i++){
            int newWheel = wheel + updown[i];
            if(newWheel<=4 && newWheel>=1 && !visited[newWheel]){//1에서 4번 톱니라면
                if(wheels[wheel][2+((i+1)%2)*4] == wheels[newWheel][2+((i)%2)*4]){
                    rotateWheel[newWheel] = 0;
                }else{
                    // System.out.println("다름! " + ",newWheel : " + newWheel + ",wheel : " + wheel);
                    // System.out.println(-rotateWheel[wheel]);
                    rotateWheel[newWheel] = -rotateWheel[wheel];
                }
                rotateCheck(rotateWheel, newWheel, visited);
            }
        }
    }

    private static void rotate(int[] rotateWheel){ // 1,0,0,0
        // System.out.println("회전전 wheels상태");
        // for(int j=1;j<=4;j++){
        //   for(int k=0;k<8;k++){
        //     System.out.print(wheels[j][k]);
        //   }
        //   System.out.println();
        // }

        for(int i=1;i<=4;i++){
            int rotateDir = rotateWheel[i];
            int[] temp = new int[8];

            for(int j=0;j<8;j++){
                temp[j]=wheels[i][j];
            }

            for(int j =0;j<8;j++){
                wheels[i][j] = temp[(j+8-rotateDir)%8];

            }
        }

    }
}
