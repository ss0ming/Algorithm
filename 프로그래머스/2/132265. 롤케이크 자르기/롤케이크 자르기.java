import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> chul = new HashMap<>();
        Map<Integer, Integer> dong = new HashMap<>();
        
        for (int i=0; i<topping.length; i++) {
            int t = topping[i];
            
            if (dong.containsKey(t)) {
                dong.replace(t, dong.get(t) + 1);
            } else {
                dong.put(t, 1);
            }
        }
        
        for (int i=0; i<topping.length; i++) {
            int t = topping[i];
            
            if (chul.containsKey(t)) {
                chul.replace(t, chul.get(t) + 1);
            } else {
                chul.put(t, 1);
            }
            
            if (dong.get(t) - 1 == 0) {
                dong.remove(t);
            } else {
                dong.replace(t, dong.get(t) - 1);
            }
            
            if (chul.size() == dong.size()) answer++;
        }
        
        return answer;
    }
}