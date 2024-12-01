import java.util.*;

class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        
        for (int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (dp[i][j] != -1) {
                    int a = dp[i-1][j] == -1 ? 0 : dp[i-1][j];
                    int b = dp[i][j-1] == -1 ? 0 : dp[i][j-1];
                    dp[i][j] += (a % MOD + b % MOD) % MOD;
                }
            }
        }
        
        return dp[n][m] % MOD;
    }
}