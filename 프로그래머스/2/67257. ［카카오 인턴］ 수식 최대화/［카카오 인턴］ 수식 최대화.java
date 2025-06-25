import java.util.*;

class Solution {
    
    String[] pri = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
    
    public long solution(String expression) {
        long answer = 0;
        
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        String tmp = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp += c;
            } else {
                ops.add(c);
                nums.add(Long.parseLong(tmp));
                tmp = "";
            }
        }
        nums.add(Long.parseLong(tmp));
        
        for (String p : pri) {
            List<Long> numsCopy = new ArrayList<>(nums);
            List<Character> opsCopy = new ArrayList<>(ops);
            
            for (char c : p.toCharArray()) {
                for (int i=0; i<opsCopy.size();) {
                    if (c != opsCopy.get(i)) {
                        i++;
                        continue;
                    } else if (c == opsCopy.get(i)) {
                        if (c == '*') {
                            numsCopy.set(i, numsCopy.get(i) * numsCopy.get(i+1));
                        } else if (c == '+') {
                            numsCopy.set(i, numsCopy.get(i) + numsCopy.get(i+1));
                        } else if (c == '-') {
                            numsCopy.set(i, numsCopy.get(i) - numsCopy.get(i+1));
                        }
                        numsCopy.remove(i+1);
                        opsCopy.remove(i);
                    }
                }
            }
            answer = Math.max(answer, Math.abs(numsCopy.get(0)));
        }
        
        return answer;
    }
}