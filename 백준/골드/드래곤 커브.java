import java.util.*;
import java.io.*;


class Main {
    private static int[][] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[101][101];

        int N = Integer.parseInt(br.readLine());

        int[][] dragon = new int[N][4];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dragon[i][0] = Integer.parseInt(st.nextToken());
            dragon[i][1] = Integer.parseInt(st.nextToken());
            dragon[i][2] = Integer.parseInt(st.nextToken());
            dragon[i][3] = Integer.parseInt(st.nextToken());
        }



        int count =1;

        for(int[] curve : dragon){
            // System.out.println("round : " + count++);
            int x = curve[0];
            int y = curve[1];
            int d = curve[2];
            int g = curve[3];

            ArrayList<Node> list = new ArrayList<>();
            list.add(new Node(x,y));

            if(d ==0){
                list.add(new Node(x+1,y));
            }else if(d==1){
                list.add(new Node(x,y-1));
            }else if(d==2){
                list.add(new Node(x-1,y));
            }else if(d==3){
                list.add(new Node(x,y+1));
            }


            for(int i=0;i<g;i++){
                int axis_x = list.get(list.size()-1).x;
                int axis_y = list.get(list.size()-1).y;

                List<Node> temp = new ArrayList<>();

                for(int j=list.size()-2;j>=0;j--){
                    int new_x = axis_x - (list.get(j).y-axis_y);
                    int new_y = axis_y + (list.get(j).x-axis_x);
                    temp.add(new Node(new_x,new_y));
                    // System.out.println("i : " + i +", new_x: " + new_x + ", new_y : " +new_y);
                }

                // for(Node node : list){
                //   int new_x = axis_x - (node.y-axis_y);
                //   int new_y = axis_y + (node.x-axis_x);
                //   temp.add(new Node(new_x,new_y));
                //   System.out.println("i : " + i +", new_x: " + new_x + ", new_y : " +new_y);
                // }

                for(Node node: temp){
                    list.add(node);
                }
            }
            checkMap(list);

        }

        int answer =0;

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1){
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }



    private static void checkMap(ArrayList<Node> list){
        for(Node node : list){
            map[node.y][node.x] =1;
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


}

/*
0: x좌표가 증가하는 방향 (→)
1: y좌표가 감소하는 방향 (↑)
2: x좌표가 감소하는 방향 (←)
3: y좌표가 증가하는 방향 (↓)
*/