import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] peoples= new int[N];
            StringTokenizer st= new StringTokenizer(br.readLine());

            for(int i=0;i<N;i++){
                peoples[i] = Integer.parseInt(st.nextToken());
            }
            int count=1;
            int[] rank = new int[N];
            for(int i=0;i<N;i++){
                if(isSix(peoples,peoples[i])){
                    rank[i] = count++;
                }
            }

            for(int i=0;i<N;i++){
                // System.out.print(rank[i]+" ");
            }
            // System.out.println();

            ArrayList<Node> teams = new ArrayList<>();

            A:for(int i=0;i<N;i++){
                if(rank[i]==0){
                    continue;
                }
                for(Node team : teams){
                    if(team.team == peoples[i]){
                        continue A;
                    }
                }
                int total =0;
                int five = 0;
                int idx = 0;
                for(int j=0;j<N;j++){
                    if(peoples[i]==peoples[j]){
                        idx++;
                        if(idx==5){
                            five = rank[j];
                        }
                        // System.out.println("team :" + peoples[i] +", 위치 : " + j+ ", idx : " + idx );
                        if(idx <=4){
                            total+= rank[j];
                        }
                    }
                }
                teams.add(new Node(peoples[i],total,five));
                // System.out.println("team : " + peoples[i] + ", total : " + total + " , five :" + five);
            }

            Node min = teams.get(0);

            for(Node team :  teams){
                if(min.total > team.total){
                    min = team;
                    continue;
                }
                if(min.total == team.total){
                    if(min.five > team.five){
                        min=team;
                    }
                }
            }

            System.out.println(min.team);
        }

    }

    static class Node{
        int team;
        int total;
        int five;

        public Node(int team, int total, int five){
            this.team = team;
            this.total = total;
            this.five = five;
        }
    }

    private static boolean isSix(int[] peoples,int num){
        int count=0;
        for(int i=0;i<peoples.length;i++){
            if(peoples[i]==num){
                count++;
            }
        }
        if(count==6){
            return true;
        }
        return false;
    }
}

/**
 1
 15
 1 2 3 3 1 3 2 4 1 1 3 1 3 3 1
 18
 1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1

 **/

//1 0 2 3 4 5 0 0 6 7 8 9 10 11 12 