import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, 1_000_000);
        dp[x] = 0;
        int idx = x;
        
        while (idx <= y) {
            if (dp[idx] == 1_000_000) {
                idx++;
                continue;
            }
            
            if (check(idx+n, y)) {
                dp[idx+n] = Math.min(dp[idx] + 1, dp[idx+n]);
            } 
            if (check(idx*2, y)) {
                dp[idx*2] = Math.min(dp[idx] + 1, dp[idx*2]);
            }
            if (check(idx*3, y)) {
                dp[idx*3] = Math.min(dp[idx] + 1, dp[idx*3]);
            }
            idx++;
        }
        
        if (dp[y] == 1_000_000) return -1;
        
        return dp[y];
    }
    
    private static boolean check(int n, int y) {
        return n <= y;
    }
}