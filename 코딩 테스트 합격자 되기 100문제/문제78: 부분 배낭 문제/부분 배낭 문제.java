import java.util.Arrays;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        int[][] items1 = {{10, 19}, {7, 10}, {6, 10}};
        System.out.println(solution(items1, 15));
        int[][] items2 = {{10, 60}, {20, 100}, {30, 120}};
        System.out.println(solution(items2, 50));
    }

    static class Item{
        int weight;
        int value;
        double price;

        public Item(int w,int v, double p){
            this.weight = w;
            this.value = v;
            this.price = p;
        }
    }

    private static double solution(int[][] items, int weight_limit) {
        Item[] item = new Item[items.length];

        for(int i =0;i<items.length;i++){
            item[i] = new Item(items[i][0],items[i][1],(double) items[i][1]/items[i][0]);
        }

        Arrays.sort(item, (o1,o2)->{
            return Double.compare(o2.price,o1.price);
        });

        double totalValue =0;
        int remainingWeight=weight_limit;

        for(Item i : item){
            if(i.weight<=remainingWeight){
                totalValue+= i.value;
                remainingWeight-=i.weight;
            }else{
                double fraction = (double) remainingWeight / i.weight;
                totalValue+= i.value * fraction;
                break;
            }
        }





        return totalValue;
    }

}