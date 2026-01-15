import java.util.*;
import java.io.*;


class Main {

    private static int[] position;
    private static int N;

    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        position = new int[M];

        for(int i=0;i<M;i++){
            position[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end =  N;
        while(start<=end){
            int mid = (start+end)/2;

            if(canCover(mid)){
                end = mid-1;
            }else{
                start = mid +1;
            }

        }

        System.out.println(start);
    }

    private static boolean canCover(int h){
        int rightCover = 0;

        for(int i=0;i<position.length;i++){
            int left = position[i] -h;
            int right = position[i] +h;

            if(left<0) left =0;
            if(right>N) right=N;

            if(rightCover<left){
                return false;
            }

            if(rightCover<right){
                rightCover = right;
            }

            if(rightCover==N){
                return true;
            }
        }

        return rightCover==N;
    }


}

// 7
// 2
// 0 5