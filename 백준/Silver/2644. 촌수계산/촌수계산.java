import java.io.*;
import java.util.*;

public class Main {

    static int a;
    static int b;
    static int n;
    static int[][] arr;
    static boolean ans = false;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited[a] = true;
        dfs(a, visited,0);

        if (!ans) System.out.println(-1);
    }

    public static void dfs(int cur, boolean[] visited, int cnt) {
        if (cur == b) {
            System.out.println(cnt);
            ans = true;
        }

        for (int i=1; i<n+1; i++) {
            if (arr[cur][i] == 0 || visited[i]) continue;
            visited[i] = true;
            dfs(i, visited, cnt+1);
        }
    }
}