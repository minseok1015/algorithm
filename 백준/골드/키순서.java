
//플로이드로 생각을 해보자
// a-> c를 갈 수 있다면, c는 a와의 관계를 알고있는 것이다
// 그렇지만 a->c를 모른다고 하더라도, c->a를 갈 수 있어도 관계를 알고 있다는 뜻이다


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[][] check = new boolean[n+1][n+1];
        for(int i = 0 ; i <m ; i++){
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            check[v1][v2]=true;
        }

        for(int k=1 ; k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(check[i][k]&&check[k][j]) check[i][j]=true;
                }
            }
        }

        int[] count = new int[n+1];
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=n;j++){
                if(check[i][j]||check[j][i]) count[i]++;
            }
        }

        int answer=0;
        for(int i = 1 ; i<=n;i++){
            if(count[i]== n-1) answer++;
        }

        System.out.println(answer);

    }
}
