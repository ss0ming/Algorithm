import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for (int i=n-1; i>=0; i--) {
            while (deliveries[i] > 0 || pickups[i] > 0) {
                calc(i, deliveries, cap);
                calc(i, pickups, cap);

                answer += (i+1) * 2;
            }
        }
        
        return answer;
    }
    
    private static void calc(int idx, int[] arr, int cap) {
        for (int i=idx; i>=0; i--) {
            if (arr[i] == 0) continue;
            if (arr[i] >= cap) {
                arr[i] -= cap;
                return;
            } else {
                cap -= arr[i];
                arr[i] = 0;
            }
        }
    }
}