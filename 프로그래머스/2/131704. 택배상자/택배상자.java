import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<order.length; i++) {
            for (int j=num; j<order[i]; j++) {
                stack.add(j);
                num++;
            }
            
            if (num == order[i]) {
                answer++;
                num++;
            } else if (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}