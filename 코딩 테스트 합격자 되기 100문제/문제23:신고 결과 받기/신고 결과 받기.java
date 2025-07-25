import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> countMap = new HashMap<>();
        HashMap<String, ArrayList<String>> reportedMap  = new HashMap<>();
        HashMap<String, Integer> ansMap  = new HashMap<>();


        for(String id : id_list){   //0으로 신고 횟수 초기화
            countMap.put(id,0);
            reportedMap.put(id,new ArrayList<>());
            ansMap.put(id,0);
        }

        for(int i = 0; i<report.length ; i++){
            String[] s = report[i].split(" ");
            String from = s[0];
            String to = s[1];
            if(!reportedMap.get(to).contains(from)){
                countMap.put(to,countMap.get(to)+1);
                reportedMap.get(to).add(from);
            }
        }


        countMap.entrySet().stream().filter(entry -> entry.getValue() >= k).forEach(name->{
            reportedMap.get(name.getKey()).forEach(n->{
                ansMap.put(n,ansMap.get(n)+1);
            });
        });

        int answer[] = new int[id_list.length];

        for(int i = 0; i<answer.length;i++){
            answer[i]=ansMap.get(id_list[i]);
        }

        return answer;
    }
}