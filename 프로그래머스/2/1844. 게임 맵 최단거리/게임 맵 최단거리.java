import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = -1;
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        if (maps[0][0] == 0) return -1;
        
        bfs(maps);
        return answer;
    }
    
    public static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];
        q.add(new int[]{0, 0, 1});
        isVisited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == n-1 && cur[1] == m-1) {
                answer = cur[2];
                return;
            }
            
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (isPromising(nx, ny) && !isVisited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny, cur[2] + maps[nx][ny]});
                    isVisited[nx][ny] = true;
                }
            }
        }
    }
    
    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}