import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i<nums.length ; i++){
            map.put(nums[i],i);
        }
        int size = map.size();

        if(size<=n){
            return size;
        }else{
            return n;
        }
    }
}