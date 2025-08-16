import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long s = 1;
        long e = (long) times[times.length-1] * n;
        long answer = e;
        
        while (s <= e) {
            long mid = (s + e) / 2;
        
            long cnt = 0;
            for (int i=0; i<times.length; i++) {
                cnt += (mid / times[i]);
            }
            
            if (cnt >= n) {
                e = mid - 1;
                answer = mid;
            } else if (cnt < n) {
                s = mid + 1;
            }
        }
        
        return answer;
    }
}