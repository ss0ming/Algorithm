import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100_000;
        
        while (min <= max) {
            int mid = (min + max)/2;
            long cur = calcTime(mid, diffs, times);
            
            if (cur > limit) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return min;
    }
    
    public static long calcTime(int level, int[] diffs, int[] times) {
        long time = 0;
            
        for (int i=0; i<diffs.length; i++) {
            if (level >= diffs[i]) {
                time += times[i];
            } else {
                time += (long)((diffs[i] - level) * (times[i-1] + times[i]) + times[i]);
            }
        }

        return time;
    }
}