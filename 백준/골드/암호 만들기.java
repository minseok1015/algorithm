import java.util.*;
import java.io.*;

//조건  : 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음

class Main {
    private static char[] word;
    private static boolean[] visited;
    private static ArrayList<String> answer;
    private static int L;
    private static int C;
    private static int consonant=0; //자음 (최소 2개)
    private static int vowel=0; //모음 (최소 1개)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        word = new char[C];
        visited = new boolean[C];


        answer = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<C;i++){
            word[i] = st.nextToken().charAt(0);
        }

        back(0,0);

        Collections.sort(answer);

        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }


    private static void back(int start, int r){
        // System.out.println("consonant : " + consonant + ", vowel : "+ vowel);

        if(r==L && consonant>1 && vowel>0){
            ArrayList<Character> list = new ArrayList<>();

            for(int i=0;i<C;i++){
                if(visited[i]){
                    list.add(word[i]);
                }
            }

            list.sort((o1,o2)->o1-o2);

            StringBuilder sb = new StringBuilder();
            for(char c : list){
                sb.append(c);
            }

            answer.add(sb.toString());

            return;
        }

        // System.out.println("start : "+start +", r : " + r);

        for(int i=start;i<C;i++){
            if(!visited[i]){
                visited[i]=true;
                if(word[i]=='a'|| word[i]=='e' || word[i]=='i' || word[i]=='o' || word[i]=='u'){
                    vowel++;
                    back(i+1,r+1);
                    vowel--;
                }else{
                    consonant++;
                    back(i+1,r+1);
                    consonant--;
                }
                visited[i]=false;
            }
        }
    }




}
