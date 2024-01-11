import java.io.*;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[R][C];
            boolean[][] visited = new boolean[R][C];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
            }

            int ans = 0;

            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    if (arr[i][j] == 0 || visited[i][j]) continue;
                    visited[i][j] = true;
                    bfs(i, j, arr, visited);
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    public static void bfs(int a, int b, int[][] arr, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] ab = q.poll();
            int x = ab[0];
            int y = ab[1];

            for (int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (!isPromising(nextX, nextY) || arr[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY});
            }


        }
    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}