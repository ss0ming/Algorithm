import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[][] contact;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        contact = new int[N][M];
        int answer = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean isChanged = false;

            for (int i=0; i<N; i++) {
                Arrays.fill(contact[i], 0);
            }

            bfs();
            
            for (int i=1; i<N-1; i++) {
                for (int j=1; j<M-1; j++) {
                    if (arr[i][j] == 1 && contact[i][j] >= 2) {
                        arr[i][j] = 0;
                        isChanged = true;
                    }
                }
            }

            if (!isChanged){
                break;
            }

            answer++;
        }
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny) || visited[nx][ny]) continue;

                if (arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } else if (arr[nx][ny] == 1) {
                    contact[nx][ny]++;
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}