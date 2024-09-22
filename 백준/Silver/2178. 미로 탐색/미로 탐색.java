import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String[] strs = br.readLine().split("");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N-1 && now[1] == M-1) {
                answer = now[2];
                break;
            }
            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPromising(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }


    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}