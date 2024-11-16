import java.util.*;

class Solution {
    
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        drawMap(rectangle);
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer/2;
    }
    
    public static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == itemX && cur[1] == itemY) {
                answer = cur[2];
                return;
            }
            
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (isPromising(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static boolean isPromising(int x, int y) {
        return x >= 1 && x <= 100 && y >= 1 && y <= 100;
    }
    
    public static void drawMap(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int startI = rect[0] * 2;
            int endI = rect[2] * 2;
            
            int startJ = rect[1] * 2;
            int endJ = rect[3] * 2;
            
            for (int i=startI; i<=endI; i++) {
                for (int j=startJ; j<=endJ; j++) {
                    if (i == startI || i == endI || j == startJ || j == endJ) {
                        if (map[i][j] == 2) continue;
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
    }
}