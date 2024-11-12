import java.util.*;

class Solution {
    
    static int answer = 0;
    static int t;
    
    public int solution(int[] numbers, int target) {
        t = target;
        
        dfs(0, 0, 0, numbers);
        return answer;
    }
    
    public static void dfs(int idx, int sum, int cnt, int[] numbers) {
        if (cnt == numbers.length) {
            if (t == sum) answer++;
            return;
        }
        
        dfs(idx+1, sum+numbers[idx], cnt+1, numbers);
        dfs(idx+1, sum-numbers[idx], cnt+1, numbers);
    }
}