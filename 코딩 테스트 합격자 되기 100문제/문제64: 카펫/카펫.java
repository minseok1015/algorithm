class Solution {
    public int[] solution(int brown, int yellow) {
        int limit= brown/2;

        int xPlusY = (brown-4)/2;

        for(int x =limit; x>=1;x--){
            int y = xPlusY - x;
            if((x*y)==yellow) return new int[]{x+2,y+2};
        }

        return new int[]{-1,-1};
    }
}