import java.util.*;

class Solution {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dd = {"d", "l", "r", "u"};
    static String answer = "impossible";
    static boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x--; y--;
        r--; c--;
        dfs(n, m, x, y, r, c, k, 0, "");
        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, String route) {
        if (found) return; // 이미 정답 찾으면 중단
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k - depth || ((k - depth - dist) % 2 != 0)) return; // 가지치기

        if (x == r && y == c && depth == k) {
            answer = route;
            found = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            dfs(n, m, nx, ny, r, c, k, depth + 1, route + dd[i]);
        }
    }
}