import java.util.*;

class Solution {
    
    static int answer = 1;
    
    public int solution(String s) {
        
        if (s.length() == 1) return answer;
        
        
        for (int i=0; i<s.length(); i++) {
            check(i-1, i+1, s);
            check(i, i+1, s);
        }
        
        return answer;
    }
    
    private static void check(int l, int r, String s) {
        while (true) {
            if (inRange(l, r, s) && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        
        answer = Math.max(answer, r-l-1);
    }
    
    private static boolean inRange(int l, int r, String s) {
        return l >= 0 && r < s.length(); 
    }
}