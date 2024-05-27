import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || arr[i][j] == 0) continue;
                visited[i][j] = true;
                bfs(i, j);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cn = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++) {
                int nx = cn + dx[i];
                int ny = cy + dy[i];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                cnt++;

            }
        }

        list.add(cnt);
    }

    public static boolean isPossible(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 1;
    }
}