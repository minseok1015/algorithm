import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input =br.readLine();
        StringBuilder sb= new StringBuilder();
        // System.out.println(input);

        while(!input.startsWith("0")){
            String[] inputArr = input.split(" ");

            int n1 = Integer.parseInt(inputArr[0]);
            int n2 = Integer.parseInt(inputArr[1]);
            int n3 = Integer.parseInt(inputArr[2]);

            //제일 큰 수를 n1으로 옮김
            if(n1<n2){
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            if(n1<n3){
                int temp = n1;
                n1 = n3;
                n3 = temp;
            }

            //삼각형 조건 만족 안하는 경우
            if(n2+n3 <= n1){
                sb.append( "Invalid");
                sb.append("\n");
                input = br.readLine();
                continue;
            }

            //세 변의 길이가 모두 같은 경우
            if(n2==n3 &&  n1 ==n2 ){
                sb.append("Equilateral");
                sb.append("\n");
                input = br.readLine();
                continue;
            }

            //두 변의 길이만 같은 경우
            if(((n1==n2)&&n1!=n3) || ((n2==n3)&&n2!=n1) || ((n1==n3)&&n1!=n2) ){
                sb.append("Isosceles");
                sb.append("\n");
                input = br.readLine();
                continue;
            }

            //세 변의 길이가 모두 다른 경우
            if(n1!=n2 && n1!=n3 && n2!=n3){
                sb.append( "Scalene");
                sb.append("\n");
                input = br.readLine();
                continue;
            }


        }

        System.out.println(sb.toString());

    }
}
