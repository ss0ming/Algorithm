import java.util.*;

class Solution {
    
    static String t;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        t = target;
        
        dfs(begin, words, visited, 0);
        
        return answer;
    }
    
    public static void dfs(String now, String[] words, boolean[] visited, int cnt) {
        if (now.equals(t)) {
            if (answer == 0) answer = cnt;
            else answer = Math.min(cnt, answer);
        }
        
        for (int i=0; i<words.length; i++) {
            if (visited[i] || !compareWord(now, words[i])) continue;
            visited[i] = true;
            dfs(words[i], words, visited, cnt+1);
            visited[i] = false;
        }
    }
    
    public static boolean compareWord(String s1, String s2) {
        int cnt = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
}