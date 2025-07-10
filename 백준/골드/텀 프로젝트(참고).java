//https://www.acmicpc.net/problem/9466

//사이클 탐지/표시/카운트가 핵심

import java.io.*;
import java.util.*;

class Main {
    private static int count = 0;
    private static boolean[] visited;
    private static boolean[] isDone;
    private static int[] peoples;

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i =0; i<T;i++){
            int num = Integer.parseInt(br.readLine());
            count=0;
            peoples = new int[num+1];
            visited =new boolean[num+1];
            isDone = new boolean[num+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=num;j++){
                peoples[j]= Integer.parseInt(st.nextToken());
                // if(peoples[j]==j) isDone[j] = true;
            }

            for(int k=1;k<=num;k++){
                if(!isDone[k]){
                    dfs(k);
                }
            }


            System.out.println(num-count);


        }

    }
    private static void dfs(int node){
        //방문했으면 팀이 될 수 있으므로 count++
        if(visited[node]){
            count++;
            isDone[node]=true;
        }else{
            visited[node]=true;
        }


        if(!isDone[peoples[node]]){
            dfs(peoples[node]);
        }

        visited[node]=false;
        isDone[node]=true;

    }

}
