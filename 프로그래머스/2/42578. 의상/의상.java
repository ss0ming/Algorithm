import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> types = new HashMap<>();
        
        for (int i=0; i<clothes.length; i++) {
            String clothesType = clothes[i][1];
            
            if (types.containsKey(clothesType)) {
                types.replace(clothesType, types.get(clothesType) + 1);
            } else {
                types.put(clothesType, 1);
            }
        }
        
        for (String t : types.keySet()) {
            answer *= (types.get(t) + 1);
        }
        
        return answer-1;
    }
}