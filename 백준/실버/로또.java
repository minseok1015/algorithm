import java.util.*;
import java.io.*;

class Main {
    private static final int depth = 6;
    private static int[] numbers;

    public static void main(String[] args)throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String line;

        while(!(line=br.readLine()).equals("0")){
            StringTokenizer st =new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());

            numbers = new int[k];
            boolean[] visited = new boolean[k];

            for(int i=0;i<k;i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(visited,0,0);
            System.out.println();


        }


    }

    private static void backtracking(boolean[] visited,int start, int r){
        if(r==depth){
            for(int i=0;i<numbers.length;i++){
                if(visited[i]){
                    System.out.print(numbers[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=start;i<numbers.length;i++){
            if(!visited[i]){
                visited[i]=true;
                backtracking(visited,i+1,r+1);
                visited[i]=false;
            }
        }
    }
}
