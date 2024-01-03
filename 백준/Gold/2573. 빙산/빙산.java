import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        int answer = 0;

        while (cnt < 2) {
            melting();
            cnt = checkArr();
            if (cnt == 0) {
                answer = 0;
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }

    public static int checkArr() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            if (!isPromising(i + dx[k], j + dy[k])) continue;

            if (arr[i + dx[k]][j + dy[k]] != 0 && !visited[i + dx[k]][j + dy[k]]) {
                dfs(i + dx[k], j + dy[k], visited);
            }
        }
    }

    public static void melting() {
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) continue;
                arr[i][j] -= countSea(i, j, visited);
                if (arr[i][j] < 0) arr[i][j] = 0;
                visited[i][j] = true;
            }
        }
    }

    public static int countSea (int i, int j, boolean[][] visited) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            if (isPromising(i + dx[k], j + dy[k]) && arr[i + dx[k]][j + dy[k]] == 0 && !visited[i + dx[k]][j + dy[k]]) cnt++;
        }
        return cnt;
    }

    public static boolean isPromising(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < M;
    }
}