class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n+1][m+1];
        
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (i == 1 && j == 1) {
                    arr[i][j] = 1;
                    continue;
                }
                if (isPuddle(i, j, puddles)) continue;
                int left = arr[i][j-1];
                int up = arr[i-1][j];
                arr[i][j] = (left + up) % 1_000_000_007;
            }
        }
        
        answer = arr[n][m] % 1_000_000_007;
        
        return answer;
    }
    
    public static boolean isPuddle(int x, int y, int[][] puddles) {
        for (int i=0; i<puddles.length; i++) {
            if (puddles[i][0] == y && puddles[i][1] == x) return true;
        }
        return false;
    }
}