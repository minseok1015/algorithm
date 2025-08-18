import java.util.*;
import java.io.*;


class Main {
    private static int[] nodes;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes =new int[n];
        Arrays.fill(nodes,-1);

        int[][] edges = new int[m][2];

        for(int i=0;i<m;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer =-1;

        for(int i=0;i<m;i++){
            if(!union(edges[i][1],edges[i][0])){
                answer=i;
                break;
            }
            // for(int j=0;j<n;j++){
            //   System.out.print(nodes[j]+" ");
            // }
            // System.out.println();
        }

        System.out.println(answer+1);

    }

    private static int find(int node){
        if(nodes[node]<0){//부모 노드일 경우 return
            return node;
        }
        return find(nodes[node]);
    }

    private static boolean union(int child,int parent){
        int root1 = find(parent);
        int root2 = find(child);
        if(root1 == root2) return false;

        if(nodes[parent]!=-1){
            nodes[root2]=root1;
            return true;
        }
        if(nodes[child]!=-1){
            nodes[root1]=root2;
            return true;
        }

        nodes[root2]=root1;
        return true;
    }
}

// 6 6
// 0 1
// 1 2
// 2 3
// 3 4
// 4 5
// 5 0

// 4 4
// 0 1
// 2 3
// 0 2
// 1 3


// 6 5
// 0 1
// 2 1
// 3 1
// 4 1
// 4 0