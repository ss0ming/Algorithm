import java.util.*;

class Solution {
    public int solution(int n) {
        int nCnt = countOne(n++);
        
        
        while (true) {
            int cnt = countOne(n);
            
            if (cnt == nCnt) {
                break;
            }
            n++;
        }
        
        return n;
    }
    
    private static int countOne(int n) {
        int cnt = 0;
        
        while(n >= 2) {
            if (n % 2 == 1) {
                cnt++;
            }
            n /= 2;
            if (n == 1) {
                cnt++;
            }
        }
        
        return cnt;
    }
}