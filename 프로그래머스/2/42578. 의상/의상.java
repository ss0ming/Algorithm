import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
                System.out.println("flag");
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        
        if (map.size() == 1) {
            answer = clothes.length;
        } else {
            for (String key : map.keySet()) {
                Integer value = map.get(key);
                System.out.println(value);
                answer *= (value + 1);
            }
            answer -= 1;
        }
        
        return answer;
    }
}