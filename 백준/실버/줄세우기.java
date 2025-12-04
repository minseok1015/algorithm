import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int t=1;t<=T;t++){
            int count =0;
            StringTokenizer st= new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken()));
            sb.append(" ");

            int[] students =new int[20];

            for(int i=0;i<20;i++){
                students[i] = Integer.parseInt(st.nextToken());
                for(int j=i-1;j>=0;j--){
                    if(students[j+1]<students[j]){
                        // System.out.println("i : " + students[j+1] + ", j : " + students[j]);
                        int temp = students[j+1];
                        students[j+1] = students[j];
                        students[j] = temp;
                        count++;
                    }
                }
            }

            sb.append(count +"\n");
        }

        System.out.print(sb.toString());

    }
}


