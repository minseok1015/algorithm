import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] students = new int[N+1];

        ArrayList<Integer>[] adjList = new ArrayList[N+1];

        for(int i=0;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }


        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            students[end]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=1;i<=N;i++){
            if(students[i]==0){
                queue.add(i);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer.add(now);

            for(int next: adjList[now]){
                students[next]--;
                if(students[next]==0){
                    queue.add(next);
                }
            }
        }

        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }

    }

}
