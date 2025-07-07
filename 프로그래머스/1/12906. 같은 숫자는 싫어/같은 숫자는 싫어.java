import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int i=1; i<arr.length; i++) {
            if (stack.peek() == arr[i]) continue;
            
            stack.push(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }
        
        return answer;
    }
}