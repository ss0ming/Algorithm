import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i);
            if (stack.isEmpty() && cur == '(') {
                stack.add('(');
            } else if (cur == '(') {
                stack.add('(');
            } else if (cur == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                answer = false;
                break;
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}