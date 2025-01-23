import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<operations.length; i++) {
            String[] operation = operations[i].split(" ");
            int n = Integer.parseInt(operation[1]);
            
            if (operation[0].equals("I")) {
                pq.add(n);
                rPq.add(n);
            } else if (operation[0].equals("D") && n == 1 && !rPq.isEmpty()) {
                int tmp = rPq.poll();
                pq.remove(tmp);
            } else if (operation[0].equals("D") && n == -1 && !pq.isEmpty()) {
                int tmp = pq.poll();
                rPq.remove(tmp);
            } 
        }
        
        if (!pq.isEmpty() && !rPq.isEmpty()) {
            answer[0] = rPq.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}