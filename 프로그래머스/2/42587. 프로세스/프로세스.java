import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> pr = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            q.add(i);
            pr.add(priorities[i]);
        }
        
        while(!pr.isEmpty()) {
            int idx = q.poll();
            int prior = pr.poll();
            
            if (pr.stream().filter(n -> n > prior).count() > 0) {
                q.add(idx);
                pr.add(prior);
            } else {
                ans.add(idx);
                if (idx == location) break;
            }
        }
        
        return ans.size();
    }
}