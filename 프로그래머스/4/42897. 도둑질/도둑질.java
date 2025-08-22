class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];
        dp[0] = 0;
        dp[1] = money[1];
        dp2[0] = money[0];
        dp2[1] = money[0];
        
        for (int i=2; i<money.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp[money.length-1], dp2[money.length-2]);
    }
}