import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map =new HashMap<>();

        for(int i=0;i<N;i++){
            String input = br.readLine();
            if(input.length()<M){
                continue;
            }
            map.put(input,map.getOrDefault(input,0)+1);
        }

        List<String> words = map.entrySet().stream()
                .sorted(
                        Comparator
                                .comparing(Map.Entry<String,Integer>::getValue,Comparator.reverseOrder())
                                .thenComparing(e -> e.getKey().length(), Comparator.reverseOrder())
                                .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(String.join("\n",words));



    }


}
