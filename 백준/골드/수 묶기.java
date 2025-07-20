import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int index=-1;

        for(int i=0;i<N;i++){
            if(numbers[i]<=0){
                index=i;
            }
        }

        int location=N-1;

        int answer =0;

        //양수 계산
        while(location>index){
            //남은 계산할 수가 1개 남았을 경우는 수(양수: 가장 작은 양수, 음수: 가장 큰 음수) 묶지 말고 그냥 더함
            if(location==index+1){
                answer=answer+numbers[location];
                break;
            }

            // 수를 두개 묶어서 곱하는 것보다 더하는게 큰 경우 (ex. 1,1 이면 1*1보다 1+1이 큼)
            if(numbers[location]*numbers[location-1]>numbers[location]+numbers[location-1]){
                answer=answer+numbers[location]*numbers[location-1];
            }else{
                answer=answer+numbers[location]+numbers[location-1];
            }


            location-=2;
        }

        location=0;

        //음수 계산
        while(location<=index){
            if(location==index){
                answer=answer+numbers[location];
                break;
            }

            if(numbers[location]*numbers[location+1]>numbers[location]+numbers[location+1]){
                answer=answer+numbers[location]*numbers[location+1];
            }else{
                answer=answer+numbers[location]+numbers[location+1];
            }


            location+=2;
        }

        System.out.println(answer);
    }
}
