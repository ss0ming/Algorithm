import java.util.*;

class Solution {
    
    static Set<Long> set = new HashSet<>();
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String bin = Integer.toString(n, k);
        String[] split = bin.split("0+");
        
        for (int i=0; i<split.length; i++) {
            if (split[i].isEmpty()) continue;
            long tmp = Long.parseLong(split[i]);
            
            if (set.contains(tmp) || isPrime(tmp)) {
                answer++;
                set.add(tmp);
            }
        }
        
        return answer;
    }
    
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i=3; i<=Math.sqrt(n); i+=2) {
            if (n%i == 0) return false;
        }
        
        return true;
    }
}