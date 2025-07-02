// 실버5
// https://www.acmicpc.net/problem/11651
// 정렬

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] coor = new int[N][2];

        for(int i = 0 ; i<N;i++){
            String[] input = br.readLine().split(" ");
            coor[i][0] = Integer.parseInt(input[0]);
            coor[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(coor, (e1,e2) -> {
            if(e1[1]==e2[1]){
                return e1[0]-e2[0];
            }else{
                return e1[1]-e2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<N; i++){
            sb.append(coor[i][0]);
            sb.append(" ");
            sb.append(coor[i][1]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
