import java.io.*;
import java.util.*;


class Main {
    private static int[] budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max=0;

        for(int i =0; i<N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,budgets[i]);
        }

        int total = Integer.parseInt(br.readLine());

        int start =0;
        int end = 100000;

        while(start<=end){
            int mid = (start + end) / 2;

            if(simulate(mid)<=total){ //총 예산보다 작거나 같으면 더 큰 쪽을 탐색해도 됨
                start =  mid+1;
            }else{ //총 예산보다 크다면 작은쪽에서 탐색을 해야됨
                end = mid -1;
            }

        }

        if(simulate(max)<=total){
            System.out.println(max);
        }else{
            System.out.println(end);
        }



    }

    private static int simulate(int mid){
        int sum=0;
        for(int budget : budgets){
            if(budget<=mid){
                sum+= budget;
            }else{
                sum+=mid;
            }
        }

        return sum;
    }
}
