import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (true) {
            String result = "";
            
            for (int i=0; i<s.length(); i++) {
                Character c = s.charAt(i);
                
                if (c == '1') {
                    result += c;
                } else if (c == '0') {
                    answer[1] += 1;
                }
            }
            
            answer[0] += 1;
            s = Integer.toBinaryString(result.length());
            
            if (s.equals("1")) {
                break;
            }
        }
        
        return answer;
    }
}