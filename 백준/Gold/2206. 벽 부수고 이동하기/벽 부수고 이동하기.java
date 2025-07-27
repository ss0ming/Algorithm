import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N-1 && cur[1] == M-1) {
                System.out.println(cur[2]);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (board[nx][ny] == 0) {
                    if (cur[3] == 0 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        q.add(new int[]{nx, ny, cur[2]+1, 0});
                    } else if (cur[3] == 1 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new int[]{nx, ny, cur[2]+1, 1});
                    }
                } else if (board[nx][ny] == 1) {
                    if (cur[3] == 0) {
                        visited[nx][ny][1] = true;
                        q.add(new int[]{nx, ny, cur[2]+1, 1});
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}