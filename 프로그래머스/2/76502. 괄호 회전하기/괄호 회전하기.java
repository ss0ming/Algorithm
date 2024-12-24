import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if (s.length() % 2 != 0) return 0;
        
        for (int i=0; i<s.length(); i++) {
            if (check(i, s)) answer++;
        }
        
        return answer;
    }
    
    private static boolean check(int start, String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt((start + i) % s.length());
            
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
}