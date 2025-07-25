
class Solution {
    private static int deletedCount =0;

    public int[] solution(String s) {

        int count =0;
        while(s.length()>1){
            count++;
            int deletedS = deleteZero(s);
            s=toBinary(deletedS);
        }

        return new int[]{count,deletedCount};

    }


    private static int deleteZero(String binary){
        char[] charBinary = binary.toCharArray();
        int length =0;

        for(char c : charBinary){
            if(c=='0'){
                deletedCount++;
            }
            else{
                length++;
            }
        }

        return length;
    }
    private static String toBinary(int decimal){
        return Integer.toBinaryString(decimal);
    }
}