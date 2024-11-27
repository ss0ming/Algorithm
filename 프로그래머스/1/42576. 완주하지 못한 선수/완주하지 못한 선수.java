import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p)+1);
            } else {
                map.put(p, 1);
            }
        }
        
        for (String c : completion) {
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.replace(c, map.get(c)-1);
            }
        }
        
        for (String key : map.keySet()) {
            answer = key;
        }
        
        return answer;
    }
}