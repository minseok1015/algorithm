import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> list= new ArrayList<>();

        int[] dm = {-1,1,0,0};
        int[] dn = {0,0,-1,1};

        int[] point;
        while((point=find(map))!=null){
            int count=1;
            queue.add(new Node(point[0],point[1]));
            map[point[0]][point[1]]=0;

            while(!queue.isEmpty()){
                Node now = queue.poll();

                for(int i=0;i<4;i++){
                    int new_m = now.m + dm[i];
                    int new_n = now.n + dn[i];

                    if(new_m<0||new_n<0|| new_m>=N || new_n>=N){
                        continue;
                    }

                    if(map[new_m][new_n]==1){
                        map[new_m][new_n] = 0;
                        queue.add(new Node(new_m,new_n));
                        count++;
                    }
                }
            }

            list.add(count);
        }

        System.out.println(list.size());

        list.sort((a,b)->a-b);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }


    }


    private static int[] find(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]==1){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    static class Node{
        int m;
        int n;

        public Node(int m, int n){
            this.m = m;
            this.n = n;
        }
    }
}
