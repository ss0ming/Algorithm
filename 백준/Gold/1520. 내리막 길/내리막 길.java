import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int m;
    static int n;
    static int[][] arr;
    static long[][] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new long[m][n];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static long dfs(int x, int y) {

        if (x == m-1 && y == n-1) {
            return 1;
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0;

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isPromising(nx, ny)) continue;

                if (arr[x][y] > arr[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];

    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}