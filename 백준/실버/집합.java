import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<M;i++){
            String[] input = br.readLine().split(" ");
            if(input[0].startsWith("add")){
                set.add(Integer.parseInt(input[1]));
            }else if(input[0].startsWith("remove")){
                set.remove(Integer.parseInt(input[1]));
            }else if(input[0].startsWith("check")){
                if(set.contains(Integer.parseInt(input[1]))){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }else if(input[0].startsWith("toggle")){
                if(set.contains(Integer.parseInt(input[1]))){
                    set.remove(Integer.parseInt(input[1]));
                }else{
                    set.add(Integer.parseInt(input[1]));
                }
            }else if(input[0].startsWith("all")){
                for(int j=1;j<=20;j++){
                    set.add(j);
                }
            }else if(input[0].startsWith("empty")){
                set.clear();
            }
        }

        System.out.println(sb.toString());

    }
}
