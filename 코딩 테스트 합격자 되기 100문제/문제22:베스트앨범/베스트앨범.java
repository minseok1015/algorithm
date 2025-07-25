import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genreMap = new HashMap<>();
        HashMap<String,ArrayList<int[]>> musicMap = new HashMap<>();

        for(int i = 0 ; i<genres.length ;  i++){
            String genre = genres[i];
            int play =  plays[i];
            if(!genreMap.containsKey(genre)){
                musicMap.put(genre,new ArrayList<>());
                genreMap.put(genre,0);
            }
            musicMap.get(genre).add(new int[]{i, play});
            genreMap.put(genre,genreMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        Stream<Map.Entry<String, Integer>> genreStream = genreMap.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        genreStream.forEach(entry->{
            Stream<int[]> musicStream = musicMap.get(entry.getKey()).stream().sorted((o1,o2)->Integer.compare(o2[1],o1[1])).limit(2);
            musicStream.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}