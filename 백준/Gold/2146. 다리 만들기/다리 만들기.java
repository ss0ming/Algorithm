import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] map;
    static int[][] color;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int answer = 201;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        color = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        int c = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    painting(i, j, c, visited);
                    c++;
                }
            }
        }

        findEdge();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] > 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer-1);
    }

    private static void painting(int x, int y, int c, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        color[x][y] = c;
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
                q.add(new int[]{nx, ny});
                color[nx][ny] = c;
                visited[nx][ny] = true;
            }
        }
    }

    private static void findEdge() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 0) continue;
                for (int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (inRange(nx, ny) && map[nx][ny] == 0) {
                        map[i][j]++;
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] > 0 && color[x][y] != color[cur[0]][cur[1]]) {
                answer = Math.min(answer, cur[2]);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny) || visited[nx][ny]) continue;
                q.add(new int[]{nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}