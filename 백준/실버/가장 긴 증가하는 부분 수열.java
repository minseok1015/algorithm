import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers= new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++ ){
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        int[] answer = new int[N];

        answer[0]=1;

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(numbers[i]<=numbers[j]){
                    continue;
                }
                answer[i] = Math.max(answer[j],answer[i]);
            }
            answer[i] = answer[i]+1;
        }


        System.out.println(Arrays.stream(answer).max().getAsInt());
    }
}
