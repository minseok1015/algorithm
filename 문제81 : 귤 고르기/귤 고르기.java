import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }

        List<Node> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(new Node(entry.getKey(),entry.getValue()));
        }

        list.sort((o1,o2)-> o2.num-o1.num);

        int answer=0;

        for(int i=0;i<list.size();i++){
            if(list.get(i).num <= k){
                k-=list.get(i).num;
                answer++;
                // System.out.println("노드의 키 : " +list.get(i).value+", 뺀 값 :" +list.get(i).num);
            }else if(k>0){
                k=0;
                answer++;
                break;
            }else{
                break;
            }
        }


        return answer;

    }

    static class Node{
        int value;
        int num;

        public Node(int v,int n){
            this.value =v;
            this.num =n;
        }
    }
}