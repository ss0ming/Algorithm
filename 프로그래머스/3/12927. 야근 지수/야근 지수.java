import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<works.length; i++) {
            pq.add((long) works[i]);
        }
        
        for (int i=0; i<n; i++) {
            long work = pq.poll();
            if (work - 1 <= 0) {
                pq.add((long) 0);
            } else {
                pq.add(work - 1);
            }
        }
        
        for (int i=0; i<works.length; i++) {
            long work = pq.poll();
            answer += (work * work); 
        }
        
        return answer;
    }
}