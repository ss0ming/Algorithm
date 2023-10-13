class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        
        int minN = Integer.parseInt(nums[0]);
        int maxN = Integer.parseInt(nums[0]);
        
        for (int i=1; i<nums.length; i++) {
            int curN = Integer.parseInt(nums[i]);
            if (minN > curN) {
                minN = curN;
            }
            if (maxN < curN) {
                maxN = curN;
            }
        }
        
        answer += Integer.toString(minN);
        answer += " ";
        answer += Integer.toString(maxN);
        
        return answer;
    }
}