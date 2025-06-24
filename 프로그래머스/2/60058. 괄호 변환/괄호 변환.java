import java.util.*;

class Solution {
    public String solution(String p) {
        return make(p);
    }
    
    public static String make(String w) {
        String answer = "";
        
        if (w.equals("")) {
            return answer;
        }
        
        int open = 0;
        int close = 0;
        int idx = 0;
        for (int i=0; i<w.length(); i++) {
            if (w.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            
            if (open == close) {
                idx = i+1;
                break;
            }
        }
        
        String u = w.substring(0, idx);
        String v = w.substring(idx, w.length());
        
        if (check(u)) {
            return u + make(v);
        }
        
        String tmp = "";
        tmp += "(";
        tmp += make(v);
        tmp += ")";
        
        u = u.substring(1, u.length() - 1);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return tmp + sb.toString();
    }
    
    public static boolean check(String w) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<w.length(); i++) {
            Character c = w.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if(stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        
        return true;
    }
}