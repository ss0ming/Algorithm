import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int maxH = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, arr[i][j]);
            }
        }

        rainFall();

        System.out.println(answer);
    }

    public static void countSafeZone(int[][] copyArr) {
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (copyArr[i][j] == 1 || visited[i][j]) continue;
                visited[i][j] = true;
                bfs(i, j, copyArr, visited);
                cnt++;
            }
        }

        answer = Math.max(cnt, answer);
    }

    public static void rainFall() {
        for (int i=1; i<=maxH; i++) {
            int[][] copyArr = new int[N][N];
            flood(i, copyArr);
            countSafeZone(copyArr);
        }
    }

    public static void flood(int n, int[][] copyArr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] <= n) {
                    copyArr[i][j] = 1;
                }
            }
        }
    }

    public static void bfs(int x, int y, int[][] arr, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPromising(nx, ny) && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}