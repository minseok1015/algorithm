import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input =br.readLine();
        int[] alpha = new int[30];

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(c >= 'a'){ //소문자일 경우
                alpha[c-'a']++;
            }else{ //대문자일 경우
                alpha[c-'A']++;
            }
        }

        int max=-1;

        for(int i=0;i<30;i++){
            if(max<alpha[i]){
                max = alpha[i];
            }
        }

        int count=0;
        int alphabet= -1;
        for(int i=0;i<30;i++){
            if(max==alpha[i]){
                count++;
                alphabet= i;
            }
        }

        char c= (char) ('A' + alphabet);


        if(count>1){
            System.out.println("?");
        }else{
            System.out.println(c);
        }

    }
}
