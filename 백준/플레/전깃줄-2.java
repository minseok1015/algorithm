import java.util.*;
import java.io.*;


class Main {
    private static ArrayList<Integer> list;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> num = new ArrayList<>();
        list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num.add(new Node(a,b));
        }

        num.sort((o1,o2)->o1.a-o2.a);

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int n1 = num.get(i).b;

            int p; //이 원소가 들어갈 위치

            if(list.isEmpty() || list.get(list.size()-1) < n1){
                p=list.size();
                list.add(n1);
            }else{
                p = search(n1);
                list.set(p,n1);
            }

            arr[i] = p;

            // System.out.print("list : ");
            // for(int j=0;j<list.size();j++){
            //   System.out.print(list.get(j)+" ");
            // }
            // System.out.println();
        }

        int answer = num.size() - list.size();

        System.out.println(answer);


        // System.out.println("arr:");
        // for(int j=0;j<n;j++){
        //   System.out.print(arr[j]+" ");
        // }
        // System.out.println();

        int point = list.size();

        boolean[] visited = new boolean[n];

        for(int i=n-1;i>=0;i--){
            if(arr[i]==point-1){
                visited[i]=true;
                point--;
            }
            if(point==0) break;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                System.out.println(num.get(i).a);
            }
        }





    }

    private static int search(int num){
        int l=0;
        int r=list.size()-1;

        // System.out.println("r : " + r);

        while(l<=r){
            int mid = (l+r)/2;
            if(num < list.get(mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return l;
    }

    private static class Node{
        int a;
        int b;

        public Node(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
}


// 9
// 1 50000
// 2 4
// 3 11
// 4 12
// 5 6
// 6 3
// 7 2
// 8 9
// 9 10

// 6
// 1 1
// 2 2
// 3 3
// 4 5
// 5 6
// 6 4