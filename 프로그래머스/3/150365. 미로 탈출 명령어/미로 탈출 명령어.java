import java.util.*;

class Solution {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static Character[] dir = {'d', 'l', 'r', 'u'};
    static String answer = null;
    static int K;
    static int N;
    static int M;
    static int R;
    static int C;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        K = k;
        N = n;
        M = m;
        R = r;
        C = c;
        
        String tmp = "";
        dfs(x, y, tmp);
        
        if (answer == null) {
            return "impossible";
        }

        return answer;
    }
    
    private static void dfs(int x, int y, String tmp) {
        if (answer != null) return;
        
        if (tmp.length() == K) {
            if (R == x && C == y) {
                answer = tmp;
            }
            return;
        }
        
        int dist = Math.abs(x - R) + Math.abs(y - C);
        int depth = tmp.length();
        if ((K - depth) < dist || (K - depth - dist) % 2 != 0) return;

        
        for (int i=0; i<4; i++) {
            if (!isPromising(x + dx[i], y + dy[i])) continue;
            dfs(x + dx[i], y + dy[i], tmp + dir[i]);
        }
    }
    
    private static boolean isPromising(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}