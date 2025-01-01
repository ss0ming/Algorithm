import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int p=0; p<priorities.length; p++) {
            q.add(new int[]{priorities[p], p});
            pq.add(priorities[p]);
        }

        while (true) {
            int[] cur = q.poll();
            
            if (cur[0] < pq.peek()) {
                q.add(new int[]{cur[0], cur[1]});
            } else {
                answer++;
                if (cur[1] == location) {
                    break;
                }
                pq.poll();
            }
        }
        
        return answer;
    }
}