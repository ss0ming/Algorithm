import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (n > 0) {
            if (pq.isEmpty()) {
                break;
            }
            int tmp = pq.poll();
            if (tmp-1 > 0) {
                pq.offer(tmp-1);
            }
            n--;
        }
        
        while (!pq.isEmpty()) {
            int tmp = pq.poll();
            
            answer += (tmp * tmp);
        }
        
        return answer;
    }
}