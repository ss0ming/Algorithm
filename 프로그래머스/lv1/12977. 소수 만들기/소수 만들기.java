class Solution {
    static int answer = 0;
    static int[] ns;
    
    public int solution(int[] nums) {
        
        ns = new int[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            ns[i] = nums[i];
        }

        dfs(0, 0, 0);
        

        return answer;
    }
    
    public static void dfs(int idx, int cnt, int sum) {
        if (cnt == 3) {
            if (isPrime(sum)) {
                answer++;
            }            
            return;
        } else {
            for (int i=idx; i<ns.length; i++) {
                dfs(i+1, cnt+1, sum+ns[i]);
            }
        }
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        
        for (int i=2; i<n; i++) {
            if (n%i == 0) return false;
        }
        
        return true;
    }
}