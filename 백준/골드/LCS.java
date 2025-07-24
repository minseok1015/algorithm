import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        int n= input1.length();
        int m= input2.length();

        char[] list1 = new char[n+1];
        char[] list2 = new char[m+1];


        for(int i=1;i<=n;i++){
            list1[i] = input1.charAt(i-1);
        }

        for(int i=1;i<=m;i++){
            list2[i] = input2.charAt(i-1);
        }

        int[][] dp =new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(list1[i]==list2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int max=0;

        for(int i=1;i<=n;i++){
            max= Math.max(max,Arrays.stream(dp[i]).max().getAsInt());
        }

        System.out.println(max);


    }
}
