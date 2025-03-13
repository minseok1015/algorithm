
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        int[] item = new int[n+1];
        int[][] distance = new int[n+1][n+1];
        final int INF = 100*15;
        for(int i = 0 ; i< distance.length;i++){
            Arrays.fill(distance[i],INF);
        }
        for(int i=1;i<=n;i++){
            for(int j =1; j<=n;j++){
                if(i==j) distance[i][j] = 0;
            }
        }

        input =br.readLine().split(" ");
        for(int i=0 ;i <n; i++){
            item[i+1] = Integer.parseInt(input[i]);
        }

        for(int i = 0 ; i<r; i++){
            input =br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            distance[v1][v2] = Math.min(d,distance[v1][v2]);
            distance[v2][v1] = Math.min(d,distance[v2][v1]);
        }

        for(int k = 1 ; k<=n;k++){
            for(int i =1 ; i<=n; i++){
                if(k==i) continue;
                for(int j=1; j<=n; j++){
                    if(k==j||i==j) continue;
                    distance[i][j] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        int answer = 0;
        for(int i=1 ; i<=n;i++){
            int sum=0;
            for(int j=1 ; j<=n; j++){
                if(distance[i][j]<=m) sum+=item[j];
            }
            answer=Math.max(answer,sum);
        }
        System.out.println(answer);


    }
}
