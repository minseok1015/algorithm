import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        ArrayDeque<Node> stack = new ArrayDeque<>();    //스택선언
        ArrayList<Integer> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(i);
        }

        for(int i=0;i<cmd.length;i++){
            String c = cmd[i];
            if(c.charAt(0)=='U'){//위로 이동
                k= k- Integer.parseInt(c.substring(2));
            }
            if(c.charAt(0)=='D'){//아래로 이동
                k= k+ Integer.parseInt(c.substring(2));
            }
            if(c.charAt(0)=='C'){//삭제
                stack.push(new Node(k, graph.get(k)));
                graph.remove(k);
                if(k==graph.size()){ //마지막 행이었을 경우
                    k--;
                }
            }
            if(c.charAt(0)=='Z'){//복구
                Node node = stack.pop();
                graph.add(node.getIndex(), node.getName());
                if (node.getIndex() <= k) { // 복구된 노드가 현재 커서보다 위라면 k 증가
                    k++;
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("O");
        }

        while(!stack.isEmpty()){
            Node node = stack.pop();
            int index = node.getName();
            sb.setCharAt(index,'X');
        }

        return sb.toString();
    }

    class Node{
        int index;
        int name;

        public Node(int index, int name){
            this.index = index;
            this.name = name;
        }
        public int getIndex(){
            return this.index;
        }
        public int getName(){
            return this.name;
        }
    }
}
