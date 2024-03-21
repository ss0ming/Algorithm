import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        
        return answer;
    }
    
    public static void dfs(int k, int[][] dungeons, boolean[] visited, int depth) {
        answer = Math.max(answer, depth);
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k || k - dungeons[i][1] < 0) continue;
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, visited, depth + 1);
            visited[i] = false;
        }
    }
}