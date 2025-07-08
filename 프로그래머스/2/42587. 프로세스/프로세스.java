import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 준비
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(i);
        }
        
        // 우선순위 별로 하나씩 빼기
        int pqNum = pq.poll();
        while (!q.isEmpty()) {
            int idx = q.poll();
            
            if (priorities[idx] == pqNum) {
                answer++;
                if (!pq.isEmpty()) {
                    pqNum = pq.poll();
                }
                if (idx == location) break;
            } else {
                q.add(idx);
            }

        }
        
        return answer;
    }
}