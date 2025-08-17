import java.util.*;

class Solution {
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        int[][][] costs = new int[N][N][4];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        pq.add(new int[]{0, 0, 0, 0});
        pq.add(new int[]{0, 0, 3, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (cur[0] == N-1 && cur[1] == N-1) {
                break;
            }
            
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int cost = cur[2] == i ? cur[3] + 100 : cur[3] + 600;
                
                if (!inRange(nx, ny) || board[nx][ny] == 1) continue;
                
                if (cost < costs[nx][ny][i]) {
                    costs[nx][ny][i] = cost;
                    pq.add(new int[]{nx, ny, i, cost});
                }
            }
        }
        
        return Arrays.stream(costs[N - 1][N - 1]).min().getAsInt();
    }
    
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}