import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> stack = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
            } else if((int)Math.ceil((100.0 - progresses[stack.peek()]) / speeds[stack.peek()]) < (int)Math.ceil((100.0 - progresses[i]) / speeds[i])) {
                answer.add(stack.size());
                stack.clear();
                stack.add(i);
            } else {
                stack.add(i);
            }
        }
        if (!stack.isEmpty()) answer.add(stack.size());
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}