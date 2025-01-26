import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        if (pq.peek() >= K) return answer;
        
        while (true) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            int minSc = pq.poll();
            int nextSc = pq.poll();
            
            pq.add(minSc + (nextSc * 2));
            answer++;
            if (pq.peek() >= K) break;
        }
        
        return answer;
    }
}