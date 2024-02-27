import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++) {
            q.add(scoville[i]);
        }
        
        int sco = q.peek();
        while (sco < K && q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            sco = a + (b * 2);
            q.add(sco);
            answer++;
            sco = q.peek();
        }
        
        if (sco < K) answer = -1;
        
        return answer;
    }
}