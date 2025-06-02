import java.util.*;

class Solution {
    
    static Character[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] start = {-1,  -1};
    static int[] target = {-1, -1};
    static int answer = -1;
    
    public int solution(String[] board) {
        
        init(board);
        // System.out.println(board[0]);
        bfs();
        
        return answer;
    }
    
    private void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[arr.length][arr[0].length];
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == target[0] && cur[1] == target[1]) {
                answer = visited[cur[0]][cur[1]]-1;
                break;
            }
            
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                while (true) {
                    if (isPromising(nx, ny) && arr[nx][ny] != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                } 
                if (visited[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                }
                    
            }
        }
    }
    
    private boolean isPromising(int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y <arr[0].length;
    }
    
    private void init(String[] board) {
        arr = new Character[board.length][board[0].length()];
        
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                arr[i][j] = board[i].charAt(j);
                if (arr[i][j] == 'G') {
                    target[0] = i;
                    target[1] = j;
                } else if (arr[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
    }
}