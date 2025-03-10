import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];

        ArrayList<Integer>[] adList = new ArrayList[N+1];
        for(int i = 0;  i <=N ; i++){
            adList[i]=new ArrayList<>();
        }
        for(int i = 0 ; i < N-1 ; i ++){
            String[] input= br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            adList[v1].add(v2);
            adList[v2].add(v1);
        }

        ArrayDeque<Integer> queue= new ArrayDeque<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int now = queue.poll();


            for(int next: adList[now]){
                if(!visited[next]){
                    visited[next] =true;
                    parent[next] = now;
                    queue.add(next);
                }
            }


        }
        for(int i = 2 ; i <= N ; i++){
            System.out.println(parent[i]);
        }
    }
}
