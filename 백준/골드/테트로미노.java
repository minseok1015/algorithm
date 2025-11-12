import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N  = Integer.parseInt(input[0]);
        int M  = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for(int i=0;i<N;i++){
        //   for(int j=0;j<M;j++){
        //     System.out.print(map[i][j] +" ");
        //   }
        //   System.out.println();
        // }

        int answer = 0;
        int sum=0;

        // 일자 모양
        for(int i=0;i<N;i++){
            for(int j=0;j<M-3;j++){
                sum = map[i][j] + map[i][j+1] + map[i][j+2] +map[i][j+3];
                answer = Math.max(answer,sum);
            }
        }
        for(int i=0;i<N-3;i++){
            for(int j=0;j<M;j++){
                sum = map[i][j] + map[i+1][j] + map[i+2][j] +map[i+3][j];
                answer = Math.max(answer,sum);
            }
        }

        // 네모 모양
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-1;j++){
                sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                answer = Math.max(answer,sum);
            }
        }

        // 'ㄴ' 자 모양
        for(int i=0;i<N-2;i++){
            for(int j=0;j<M-1;j++){
                sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                answer = Math.max(answer,sum);
                sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                answer = Math.max(answer,sum);
                sum = map[i+2][j] + map[i+2][j+1] + map[i+1][j+1] + map[i][j+1];
                answer = Math.max(answer,sum);
                sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
                answer = Math.max(answer,sum);
            }
        }
        // 'ㄴ' 자 모양
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-2;j++){
                sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
                answer = Math.max(answer,sum);
                sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                answer = Math.max(answer,sum);
                sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                answer = Math.max(answer,sum);
                sum = map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                answer = Math.max(answer,sum);
            }
        }

        // 'ㄹ' 자 모양 - 1

        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-2;j++){
                sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                answer = Math.max(answer,sum);
                sum = map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1];
                answer = Math.max(answer,sum);
            }
        }
        // 'ㄹ' 자 모양 - 2
        for(int i=0;i<N-2;i++){
            for(int j=0;j<M-1;j++){
                sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                answer = Math.max(answer,sum);
                sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                answer = Math.max(answer,sum);
            }
        }


        // 'ㅗ' 자 모양 - 1
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-2;j++){
                sum = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
                answer = Math.max(answer,sum);
                sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                answer = Math.max(answer,sum);
            }
        }
        // 'ㅗ' 자 모양 - 2
        for(int i=0;i<N-2;i++){
            for(int j=0;j<M-1;j++){
                sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
                answer = Math.max(answer,sum);
                sum = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
                answer = Math.max(answer,sum);
            }
        }

        System.out.println(answer);


    }
}
