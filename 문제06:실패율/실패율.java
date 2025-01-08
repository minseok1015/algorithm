import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        Stage[] stage = new Stage[N];
        for(int i = 0 ;i<N;i++){
            int finalI = i+1;
            double clear = Arrays.stream(stages).filter(item-> item >= finalI).toArray().length;
            if(clear==0){
                stage[i]=new Stage(finalI,0);
            }else{
                stage[i] = new Stage(finalI,
                        Arrays.stream(stages).filter(item -> item == finalI).toArray().length / clear);
            }

        }

        return Arrays.stream(stage).sorted(Comparator.comparingDouble(Stage::getRate).reversed().thenComparing(Stage::getNumber)).mapToInt(Stage::getNumber).toArray();

    }

    class Stage{
        private int number;
        private double rate;

        public Stage(int number,double rate){
            this.number = number;
            this.rate = rate;
        }


        public int getNumber(){
            return this.number;
        }
        public double getRate(){
            return this.rate;
        }
    }
}