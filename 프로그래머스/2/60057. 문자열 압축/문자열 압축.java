import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i=1; i<s.length()/2+1; i++) {
            int cnt = 1;
            String target = s.substring(0, i);
            String res = "";
            
            for (int j=i; j<s.length(); j+=i) {
                int end = Math.min(j+i, s.length());
                String cmp = s.substring(j, end);
                
                if (target.equals(cmp)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        res += target;
                    } else {
                        res += (Integer.toString(cnt) + target);
                        cnt = 1;
                    }
                    target = cmp;
                }
                
                
            }
            if (cnt == 1) {
                res += target;
            } else {
                res += (Integer.toString(cnt) + target);
            }
            answer = Math.min(answer, res.length());
        }
        
        return answer;
    }
}