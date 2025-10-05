import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> line = new ArrayList<>();

        for(int i = 0;i<n;i++){
            StringTokenizer  st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if(v1<v2){
                line.add(new Node(v1,v2));
            }else{
                line.add(new Node(v2,v1));
            }
        }

        line.sort((o1,o2)->o1.end-o2.end);

        int d = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int result= 0;

        for(Node node : line){
            if((node.end-node.start)>d){  // 사이의 거리가 철도 보다 긴경우 pass
                continue;
            }
            pq.offer(node.start);

            while(!pq.isEmpty()){
                if(pq.peek() >= node.end-d){
                    break;
                }

                pq.poll();
            }

            result = Math.max(result,pq.size());
        }
        System.out.println(result);

    }

    private static class Node{
        int start;
        int end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
