import java.util.*;
import java.io.*;


class Main {
    private static int[] cards;
    private static int[] sets;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());

        cards = new int[M];
        sets = new int[M+1];

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            cards[i] = Integer.parseInt(st.nextToken());
            sets[i] = i;
        }
        sets[M]=M;

        Arrays.sort(cards);

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<K;i++){
            int num = Integer.parseInt(st.nextToken());
            int point = search(num);
            point = find(point);
            System.out.println(cards[point]);
            union(point,point+1);
        }

    }

    private static int search(int num){
        int l =0;
        int r =cards.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(num < cards[mid]){
                r=mid-1;
            }else{

                l=mid+1;
            }
        }
        return l;
    }

    private static int find(int x){
        if(x==sets[x]) return x;
        return sets[x] = find(sets[x]);
    }

    private static void union(int x, int y){
        int find_x = find(x);
        int find_y = find(y);

        if(find_x==find_y) return;
        else if(find_x>find_y){
            sets[find_y] = find_x;
        }else{
            sets[find_x] = find_y;
        }
    }

}


// 철수 : 아무거나 낼 수 있음
// 민수 : 철수가 낼 것 중에서 큰 수지만 그 중에 작은 수의 카드를 냄