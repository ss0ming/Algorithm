class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];
        
        for (int[] r : results) {
            win[r[0]][r[1]] = true;
            lose[r[1]][r[0]] = true;
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=n; k++) {
                    if (win[j][i] && win[i][k]) {
                        win[j][k] = true;
                    }
                    if (lose[j][i] && lose[i][k]) {
                        lose[j][k] = true;
                    }
                }
            }
        }
        
        for (int i=1; i<n+1; i++) {
            int cnt = 0;
            for (int j=1; j<n+1; j++) {
                if (win[i][j] || lose[i][j]) cnt++;
            }
            if (cnt == n-1) answer++;
        }
        
        return answer;
    }
}