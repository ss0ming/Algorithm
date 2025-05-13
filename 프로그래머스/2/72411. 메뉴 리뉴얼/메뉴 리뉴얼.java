import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i=0; i<course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int c = course[i];
            for (int j=0; j<orders.length; j++) {
                char[] order = orders[j].toCharArray();
                Arrays.sort(order);
                dfs(map, "", c, 0, order);
            }
            
            if (map.size() > 0) {
                int max = -1;
                for (String key : map.keySet()) {
                    if (map.get(key) > 1) {
                        max = Math.max(max, map.get(key));
                    }
                }
                for (String key : map.keySet()) {
                    if (max == map.get(key)) {
                        answer.add(key);
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
    
    private static void dfs(Map<String, Integer> map, String tmp, int c, int cur, char[] order) {
        if (tmp.length() == c) {
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
            return;
        }
        
        for (int i=cur; i<order.length; i++) {
            dfs(map, tmp+order[i], c, i+1, order);
        }
    }
}