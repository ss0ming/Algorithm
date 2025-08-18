class Solution {
    public int solution(int n, int[] money) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 0; i < money.length; i++) {
            int cur = money[i];
            for (int j = cur; j <= n; j++) {
                dp[j] += dp[j - cur];
                dp[j] %= 1_000_000_007;
            }
        }

        return (int) dp[n];
    }
}