import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i=0; i<s.length(); i++) {
            String first = s.substring(0, 1);
            String last = s.substring(1);
            s = last + first;
            if (isRight(s)) answer++;
        }
        
        return answer;
    }
    
    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        boolean flag = true;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() && isOpenStr(c)) {
                stack.add(c);
            } else if (stack.isEmpty() && isCloseStr(c)) {
                flag = false;
            } else if (isOpenStr(c)) {
                stack.add(c);
            } else if (isCloseStr(c)) {
                char topStack = stack.peek();
                if (c == ')' && topStack == '(') {
                    stack.pop();
                } else if (c == ']' && topStack == '[') {
                    stack.pop();
                } else if (c == '}' && topStack == '{') {
                    stack.pop();
                } else {
                    flag = false;
                }
            }
            
            if (!flag) break;
        }
        if (!stack.isEmpty()) flag = false;
        return flag;
    }
    
    public boolean isOpenStr(char c) {
        if (c == '(') return true;
        else if (c == '[') return true;
        else if (c == '{') return true;
        return false;
    }
    
    public boolean isCloseStr(char c) {
        if (c == ')') return true;
        else if (c == ']') return true;
        else if (c == '}') return true;
        return false;
    }
}