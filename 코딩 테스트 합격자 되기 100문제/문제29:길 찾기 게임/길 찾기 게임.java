import java.util.*;
import java.util.stream.*;

class Solution {
    ArrayList<Integer> preList = new ArrayList<>();
    ArrayList<Integer> postList = new ArrayList<>();


    public void pre(Node node){
        if(node==null){
            return;
        }

        preList.add(node.getNum());
        pre(node.getL_Node());
        pre(node.getR_Node());

    }

    public void post(Node node){
        if(node==null){
            return;
        }

        post(node.getL_Node());
        post(node.getR_Node());
        postList.add(node.getNum());
    }

    public int[][] solution(int[][] nodeinfo) {
        HashMap<Integer, Integer> xMap = new HashMap<>();
        int[] order =new int[nodeinfo.length];


        for(int i = 0; i< order.length;  i++){
            xMap.put(i+1,nodeinfo[i][1]);
        }

        order = xMap.entrySet().stream()
                .sorted((o1,o2)->Integer.compare(o2.getValue(),o1.getValue()))
                .mapToInt(entry -> entry.getKey()).toArray();

        Node root = new Node(order[0],nodeinfo[order[0]-1][0]);

        for(int i =1 ; i<order.length;i++){
            int n = order[i];
            int x = nodeinfo[n-1][0];
            Node curNode = root;
            Node preNode = root;
            int flag = -1;
            while(curNode!=null){
                preNode = curNode;
                if(x < curNode.getX()){
                    curNode = curNode.getL_Node();
                    flag = 1;
                }else{
                    curNode = curNode.getR_Node();
                    flag = 0;
                }
            }
            if(flag==1){
                preNode.setL_Node(new Node(n,x));
            }
            if(flag==0){
                preNode.setR_Node(new Node(n,x));
            }
        }
        pre(root);
        post(root);

        int[] preL = preList.stream().mapToInt(Integer::intValue).toArray();
        int[] postL = postList.stream().mapToInt(Integer::intValue).toArray();

        int[][] answer = {preL,postL};

        return answer;
    }




    class Node{
        private Node l_Node;
        private Node r_Node;
        private int num;
        private int x;

        Node(int num, int x){
            this.num = num;
            this.x = x;
            this.l_Node = null;
            this.r_Node = null;
        }

        public int getX(){
            return this.x;
        }
        public int getNum(){
            return this.num;
        }

        public void setL_Node(Node node){
            this.l_Node = node;
        }
        public void setR_Node(Node node){
            this.r_Node = node;
        }
        public Node getL_Node(){
            return this.l_Node;
        }
        public Node getR_Node(){
            return this.r_Node;
        }
    }
}