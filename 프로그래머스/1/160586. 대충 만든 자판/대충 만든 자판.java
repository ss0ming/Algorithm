import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        Map<Character, Integer> key = new HashMap<>();
        
        for (int i=0; i<keymap.length; i++) {
            String k = keymap[i];
            for (int j=0; j<k.length(); j++) {
                char c = k.charAt(j);
                
                if (!key.containsKey(c)) {
                    key.put(c, j+1);
                } else {
                    if (key.get(c) > j+1) key.replace(c, j+1);
                }
            }
        }
        
        List<Integer> answer = new LinkedList<>();
        
        for (int i=0; i<targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            
            for (int j=0; j<target.length(); j++) {
                if (key.containsKey(target.charAt(j)))
                    cnt += key.get(target.charAt(j));
                else {
                    cnt = 0;
                    break;
                }
            }
            if (cnt == 0) answer.add(-1);
            else answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}