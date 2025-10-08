import java.util.*;

class Solution {
    
    static Map<String, Integer> setCnt = new HashMap<>();
    static int maxCourse = 0;
    static Map<Integer, Integer> maxCnt = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for (int c : course) {
            maxCnt.put(c, 0);
        }
        
        for (int i=0; i<orders.length; i++) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            String order = new String(tmp);
            for (int j=0; j<course.length; j++) {
                dfs(order, 0, "", 0, course[j]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (String s : setCnt.keySet()) {
            int cnt = maxCnt.get(s.length());
            if (cnt >= 2 && setCnt.get(s) == maxCnt.get(s.length())) {
                answer.add(s);
            }
        }
        
        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }
    
    private static void dfs(String s, int idx, String set, int depth, int n) {
        if (depth == n) {
            setCnt.put(set, setCnt.getOrDefault(set, 0) + 1);
            int cnt = Math.max(maxCnt.get(n), setCnt.get(set));
            maxCnt.put(n, cnt);
            return;
        }
        
        for (int i=idx; i<s.length(); i++) {
            dfs(s, i+1, set + s.charAt(i), depth+1, n);
        }
    }
}