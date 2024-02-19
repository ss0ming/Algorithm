import java.util.*;
class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int m;
    static int n;
    static int answer = -1;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
        visited[0][0] = true;
        
        bfs(maps, visited);
        
        return answer;
    }
    
    public static void bfs(int[][] maps, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            if (x == m-1 && y == n-1) {
                answer = cnt;
                break;
            }
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isPromising(nx, ny) || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, cnt+1});
            }
        }
    }
    
    public static boolean isPromising(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y< n;
    }
}