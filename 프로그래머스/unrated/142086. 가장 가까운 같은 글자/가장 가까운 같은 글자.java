import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(Character.toString(s.charAt(i)))) {
                answer[i] = i - map.get(Character.toString(s.charAt(i)));
                map.put(Character.toString(s.charAt(i)), i);
            } else {
                answer[i] = -1;
                map.put(Character.toString(s.charAt(i)), i);
            }
        }
        
        return answer;
    }
}