import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dIdx = n - 1;
        int pIdx = n - 1;
        
        while (dIdx >= 0 || pIdx >= 0) {
            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;
            if (dIdx < 0 && pIdx < 0) break;

            answer += (Math.max(dIdx, pIdx) + 1) * 2;
 
            int dCap = cap;
            while (dIdx >= 0 && dCap > 0) {
                if (deliveries[dIdx] <= dCap) {
                    dCap -= deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    dIdx--;
                } else {
                    deliveries[dIdx] -= dCap;
                    dCap = 0;
                }
            }
            
            int pCap = cap;
            while (pIdx >= 0 && pCap > 0) {
                if (pickups[pIdx] <= pCap) {
                    pCap -= pickups[pIdx];
                    pickups[pIdx] = 0;
                    pIdx--;
                } else {
                    pickups[pIdx] -= pCap;
                    pCap = 0;
                }
            }
        }
        
        return answer;
    }
}