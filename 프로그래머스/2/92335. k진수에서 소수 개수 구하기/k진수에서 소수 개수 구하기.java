import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        String[] strs = s.split("0");
        
        for (int i=0; i<strs.length; i++) {
            if (strs[i].equals("")) continue;
            long now = Long.parseLong(strs[i]);
            if (isPrime(now)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        
        for (int i=2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}