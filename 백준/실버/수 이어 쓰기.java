import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input =br.readLine();
        int length = input.length();




        System.out.println(find(length,input));
    }

    private static int find(int length,String input){
        int num=0;
        int index =0;

        while(true){
            num++;
            String strNum = String.valueOf(num);

            for(int i=0;i<strNum.length();i++){
                if(strNum.charAt(i)==input.charAt(index)){
                    index++;
                }
                if(index==length){
                    return num;
                }
            }
        }
    }
}
