import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i])+1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        int sum = 0;
        for (Integer key : keys) {
			int curValue = map.get(key);
            System.out.println(curValue);
            sum += curValue;
            answer++;
            
            if (sum >= k) break;
		}
        
        return answer;
    }
}