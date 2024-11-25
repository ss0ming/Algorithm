import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) days[i] += 1;
        }
        
        for (int i=0; i<days.length; i++) {
            if (q.isEmpty() || q.peek() >= days[i]) {
                q.add(days[i]);
            } else {
                answer.add(q.size());
                q.clear();
                q.add(days[i]);
            }
        }
        
        if (!q.isEmpty()) answer.add(q.size());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}