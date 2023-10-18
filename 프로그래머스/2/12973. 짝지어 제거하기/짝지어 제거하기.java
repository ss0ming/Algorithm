import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
            
        }
        
        if (stack.size() == 0) answer = 1;
        else answer = 0;
        
        return answer;
    }
}