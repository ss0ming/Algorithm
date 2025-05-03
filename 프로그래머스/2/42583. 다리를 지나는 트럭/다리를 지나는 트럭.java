import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        int w = 0;
        int idx = 0;
        
        while (idx < truck_weights.length) {
            int cur = truck_weights[idx];
            
            if (q.size() < bridge_length && w + cur <= weight) {
                q.add(cur);
                idx++;
                w += cur;
                answer++;
                continue;
            } else if (q.size() < bridge_length && w + cur > weight) {
                q.add(0);
                answer++;
                continue;
            } else {
                int tmp = q.remove();
                w -= tmp;
            }
            
            if (w + cur <= weight) {
                q.add(cur);
                idx++;
                w += cur;
            } else {
                q.add(0);
            }
            
            answer++;
        }
        
        answer += (bridge_length-q.size());
        answer += q.size();
        
        return answer;
    }
}