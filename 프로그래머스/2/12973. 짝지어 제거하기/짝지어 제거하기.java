import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            
            if (stack.isEmpty()) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        
        if (stack.size() == 0) {
            return 1;
        }

        return answer;
    }
}