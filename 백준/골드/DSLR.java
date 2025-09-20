import java.util.*;
import java.io.*;


class Main {

    private static char[] com = {'D','S','L','R'};

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            ArrayDeque<Node> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];

            queue.add(new Node(A,""));

            while(!queue.isEmpty()){
                Node now = queue.poll();

                if(now.num==B){  //정답이면 종료
                    bw.write(now.command.toString()+'\n');
                    break;
                }

                for(char c : com){
                    int temp = now.num;
                    int d1= temp/1000;
                    int d2= (temp%1000)/100;
                    int d3= (temp%100)/10;
                    int d4= (temp%10);
                    if(c=='D'){
                        temp = (temp*2) % 10000;
                    }else if(c=='S'){
                        if(temp==0){
                            temp=9999;
                        }else{
                            temp=temp-1;
                        }
                    }else if(c=='L'){
                        temp = d2*1000 + d3*100 + d4*10 + d1;
                    }else if(c=='R'){
                        temp = d4*1000 + d1*100 + d2*10 + d3;
                    }

                    if(!visited[temp]){
                        visited[temp]=true;
                        queue.add(new Node(temp,now.command+String.valueOf(c)));
                    }

                }


            }


        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static class Node{
        int num;
        String command;

        Node(int num,String command){
            this.num=num;
            this.command=command;
        }

    }

}
