import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);

        return answer;
    }
    
    private void dfs(int k, int cnt, int[][] dungeons, boolean[] visited) {
        if (checkVisit(visited)) {
            answer = Math.max(cnt, answer);
        }
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            
            if (k >= dungeons[i][0]) {
                dfs(k-dungeons[i][1], cnt+1, dungeons, visited);
            } else {
                dfs(k, cnt, dungeons, visited);
            }
            
            visited[i] = false;
        }
    }
    
    private boolean checkVisit(boolean[] visited) {
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}