class Solution {
    
    static int[] nums;
    static int answer = 0;
    static int t;
    static int idx = 0;
    
    public int solution(int[] numbers, int target) {
        
        nums = new int[numbers.length];
        t = target;
        
        for (int i=0; i<numbers.length; i++) {
            nums[i] = numbers[i];
        }
        
        dfs(0, 0);

        System.out.println(idx);
        return answer;
    }
    
    public static void dfs (int v, int sum) {
        if (v == nums.length) {
            idx++;
            if (sum == t) answer++;
            return;
        }
        dfs(v+1, sum+nums[v]);
        dfs(v+1, sum-nums[v]);
    }
}