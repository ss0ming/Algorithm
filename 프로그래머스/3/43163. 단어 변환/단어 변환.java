import java.util.*;

class Solution {
    
    static int answer = 10000;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(0, begin, visited, target, words);
        
        if (10000 <= answer) return 0;
        return answer;
    }
    
    public static void dfs(int cnt, String cur, boolean[] visited, String target, String[] words) {
        if (cur.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            if (!visited[i] && check(cur, words[i])) {
                visited[i] = true;
                dfs(cnt+1, words[i], visited, target, words);
                visited[i] = false;
            }
        }
    }
    
    public static boolean check(String a, String b) {
        int cnt = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) return false;
        }
        
        if (cnt == 1) return true;
        return false;
    }
}