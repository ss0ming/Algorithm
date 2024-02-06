import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int[][] arr = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            int cnt = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 0 || visited[i][j]) continue;
                    visited[i][j] = true;
                    bfs(arr, visited, i, j);
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

    }

    public static void bfs(int[][] arr, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (!isPromising(nextX, nextY, arr) || visited[nextX][nextY] || arr[nextX][nextY] == 0) continue;
                visited[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY});
            }
        }
    }

    public static boolean isPromising(int x, int y, int[][] arr) {
        return x >= 0 && y >= 0 && x < arr.length && y < arr[0].length;
    }
}