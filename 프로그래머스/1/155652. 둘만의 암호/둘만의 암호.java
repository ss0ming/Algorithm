import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
    
        List<Character> list = new LinkedList<>();
        for (int i=0; i<skip.length(); i++) {
            list.add(skip.charAt(i));
        }
        Character[] alpha = new Character[26];
        
        for (int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            if (alpha[now-97] != null) {
                answer += alpha[now-97];
                continue;
            }
            alpha[now-97] = find(list, now, index);
            answer += alpha[now-97];
        }
        
        return answer;
    }
    
    public static Character find(List<Character> list, char now, int index) {
        while (index != 0) {
            now += 1;
            if (now > 122) now = 97;
            
            if (!list.contains(now)) index--;
        }
        
        return now;
    }
}