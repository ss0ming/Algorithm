import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        
        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        int min = nums[0];
        int max = nums[0];
        
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        
        answer += (min + " " + max);
        
        return answer;
    }
}