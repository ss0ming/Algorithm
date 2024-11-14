import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            bfs(i, computers);
            answer++;
        }
        
        return answer;
    }
    
    public static void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i=0; i<computers.length; i++) {
                if (cur != i && computers[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}