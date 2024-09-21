import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void print(String message, int[][] a) {
        System.out.println(message);
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int cnt) { // 3개의 벽 고르기
        if (cnt == 3) {
            int[][] copyArr = new int[N][M];

            for (int i=0; i<N; i++) {
                copyArr[i] = arr[i].clone();
            }

            spreadVirus(copyArr); // 바이러스 퍼뜨리기
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus(int[][] copyArr) { // 바이러스 퍼짐
        boolean[][] visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 1 && !visited[i][j]) continue;
                if (copyArr[i][j] == 2) {
                    visited[i][j] = true;
                    bfs(i, j, copyArr, visited);
                }
            }
        }
        countSafeZone(copyArr);
    }

    public static void bfs(int x, int y, int[][] copyArr, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (isPromising(nx, ny) && copyArr[nx][ny] == 0 && !visited[nx][ny]) {
                    copyArr[nx][ny] = 2;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void countSafeZone(int[][] arr) { // 안전 영역 세기
        int count = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 0) count++;
            }
        }

        answer = Math.max(answer, count);
    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}