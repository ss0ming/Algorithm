import java.util.*;

class Solution {
    
    static int answer = 0;
    static String nums;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        nums = numbers;
        String tmp = "";
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(tmp, visited);

        for (int i : set) {
            check(i);
        }
        
        return answer;
    }
    
    private static void dfs(String tmp, boolean[] visited) {
        if (!tmp.equals("") && tmp.length() <= nums.length()) {
            set.add(Integer.parseInt(tmp));
        }
        
        if (tmp.length() == nums.length()) return;
        
        for (int i=0; i<nums.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(tmp, visited);
            dfs(tmp+nums.charAt(i), visited);
            visited[i] = false;
        }
    }
    
    private static void check(int n) {
        if (n <= 1) {
            return;
        } else if (n == 2) {
            answer++;
            return;
        }
        
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return;
        }
        
        answer++;
    }
}