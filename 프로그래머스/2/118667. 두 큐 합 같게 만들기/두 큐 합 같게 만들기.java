import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = 0L;
        long sum2 = 0L;
        
        Queue<Integer> st1 = new LinkedList<>();
        Queue<Integer> st2 = new LinkedList<>();
        
        for (int i=0; i<queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            st1.add(queue1[i]);
            st2.add(queue2[i]);
        }
        
        if (sum1 == sum2) return 0;

            
        while (answer <= queue1.length*2+1 && !st1.isEmpty() && !st2.isEmpty()) {

            int tmp = 0;
            if (sum1 > sum2) {
                tmp = st1.poll();
                st2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            } else if (sum1 < sum2) {
                tmp = st2.poll();
                st1.offer(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            }
            answer++;
            
            if (sum1 == sum2) return answer;
        }
        
        return -1;
    }
}