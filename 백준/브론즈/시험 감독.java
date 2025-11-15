import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int B =Integer.parseInt(st.nextToken());
        int C =Integer.parseInt(st.nextToken());

        long answer =0;

        for(int a : A){
            answer++; //총감독 무조건 한명 배치
            a -= B; //총감독 인원 빼기
            if(a <=0){
                continue; //총감독만 있어도 되는 경우
            }

            if(a%C !=0){
                answer += a/C +1;
            }else{
                answer += a/C;
            }

        }
        System.out.println(answer);

    }
}
