import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int K =Integer.parseInt(br.readLine());

        //사과 위치 저장
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
        }

        int L = Integer.parseInt(br.readLine());

        ArrayDeque<MoveInfo> queue = new ArrayDeque<>();
        ArrayDeque<Node> tail = new ArrayDeque<>();


        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new MoveInfo(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
        }

        int[] dr ={0,1,0,-1};  //오른쪽, 아래, 왼쪽, 위
        int[] dc ={1,0,-1,0};

        int currentDir = 0;

        int currentRow=0;
        int currentCol=0;

        int tailRow=0;
        int tailCol=0;


        int count=0;
        tail.add(new Node(0,0));

        while(true){
            count++;
            int newRow=currentRow+dr[currentDir];
            int newCol=currentCol+dc[currentDir];

            // System.out.println("count = " +count);
            // for(int i=0;i<N;i++){
            //   for(int j=0;j<N;j++){
            //     System.out.print(map[i][j]+" ");
            //   }
            //   System.out.println();
            // }



            // System.out.println("이동하려는 위치 row : " + (newRow+1)+", col : " +(newCol+1)+"    ,count = "+ count);


            //벽에 닿았을 경우 정지
            if(newRow<0||newCol<0||newRow>=N||newCol>=N){
                break;
            }

            //자기 몸에 닿았을 경우 정지
            if(map[newRow][newCol]==-1){
                // System.out.println("몸에 닿았음!");
                break;
            }



            //사과를 만났을때
            if(map[newRow][newCol]==1){
                map[newRow][newCol]=-1;
                tail.add(new Node(newRow,newCol));
                // System.out.println("사과 만남!");

            }else{
                map[newRow][newCol]=-1;
                tail.add(new Node(newRow,newCol));
                Node t = tail.poll();
                map[t.row][t.col]=0;
            }

            //X초가 끝난 뒤에 방향전환
            if(!queue.isEmpty() && count==queue.peek().sec){
                MoveInfo moveinfo = queue.poll();
                if(moveinfo.dir=='L'){
                    currentDir = (currentDir+3)%4;
                }else{
                    currentDir = (currentDir+1)%4;
                }
            }

            currentRow=newRow;
            currentCol=newCol;
        }

        System.out.println(count);


    }

    static class MoveInfo{
        int sec;
        char dir;

        public MoveInfo(int sec, char dir){
            this.sec=sec;
            this.dir=dir;
        }
    }

    static class Node{
        int row;
        int col;

        public Node(int r,int c){
            this.row =r;
            this.col = c;
        }
    }
}
