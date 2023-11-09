import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int N;
    public static int M;
    public static int[][] dist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        dist[0][0] = 1;
        bfs(0, 0, visited);

        System.out.println(dist[N-1][M-1]);
    }

    public static void bfs (int n, int m, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {n, m});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (!isPromising(nextX, nextY, visited)) continue;

                q.add(new int[] {nextX, nextY});
                dist[nextX][nextY] = dist[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

    public static boolean isPromising(int n, int m, boolean[][] visited) {
        if (n < 0 || n >= N || m < 0 || m >= M) return false;
        if (arr[n][m] == 0) return false;
        return !visited[n][m];
    }
}