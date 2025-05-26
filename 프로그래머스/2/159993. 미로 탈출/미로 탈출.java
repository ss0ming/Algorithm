import java.util.*;

class Solution {
    
    static Character[][] arr;
    static int sx = -1;
    static int sy = -1;
    static int ex = -1;
    static int ey = -1;
    static int lx = -1;
    static int ly = -1;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    
    public int solution(String[] maps) {
        int answer = 0;        

        init(maps);
        
        int d1 = bfs(sx, sy, lx, ly);
        int d2 = bfs(lx, ly, ex, ey);
        
        if (d1 == -1 || d2 == -1) return -1;
        
        return d1 + d2;
    }
    
    private int bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> q = new LinkedList<>();
        int[][] tmp = new int[arr.length][arr[0].length];
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (isPromising(nx, ny) && arr[nx][ny] != 'X' && !visited[nx][ny]) {
                    tmp[nx][ny] += (tmp[cur[0]][cur[1]] + 1);
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if (nx == x2 && ny == y2) {
                        return tmp[x2][y2];
                    }
                }
                
            }
        }
        return -1;
    }
    
    private boolean isPromising(int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y < arr[0].length;
    }
    
    private void init(String[] maps) {
        arr = new Character[maps.length][maps[0].length()];
        
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[0].length(); j++) {
                arr[i][j] = maps[i].charAt(j);
                if (arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (arr[i][j] == 'E') {
                    ex = i;
                    ey = j;
                } else if (arr[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
    }
}