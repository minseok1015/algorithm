import java.util.*;

class Solution {

    public String[] solution(String[] record) {
        ArrayList<String[]> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i<record.length; i++){
            String[] r = record[i].split(" ");
            String cmd = r[0];
            String uid = r[1];
            if(cmd.equals("Enter")){
                String name = r[2];
                map.put(uid,name);
                list.add(new String[]{uid,cmd});
            }else if(cmd.equals("Leave")){
                list.add(new String[]{uid,cmd});
            }else if(cmd.equals("Change")){
                String name = r[2];
                map.put(uid,name);
            }
        }

        String[] answer = new String[list.size()];
        for(int i=0 ; i<list.size();i++){
            StringBuilder sb = new StringBuilder();
            String name = map.get(list.get(i)[0]);
            String cmd = list.get(i)[1].equals("Enter") ? "들어왔습니다." : "나갔습니다.";
            sb.append(name);
            sb.append("님이");
            sb.append(" ");
            sb.append(cmd);
            answer[i] = sb.toString();
        }

        return answer;
    }
}