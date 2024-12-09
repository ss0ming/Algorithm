import java.util.*;

class Solution {
    public static int solution(int n) {
        int answer = 0;
        
        for (int i=1; i<=n; i++) {
            if (isSum(n, i)) answer++;
        }
        
        return answer;
    }
    
    private static boolean isSum(int n, int i) {
        int sum = 0;
        
        for (int j=i; j<=n; j++) {
            sum += j;
            
            if (n == sum) {
                return true;
            } else if (sum > n) {
                return false;
            }
        }
        
        return false;
    }
}