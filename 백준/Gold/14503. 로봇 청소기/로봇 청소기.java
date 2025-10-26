import java.io.*;
import java.util.*;

class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                answer++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4; // 왼쪽 회전
                int nx = r + dx[dir];
                int ny = c + dy[dir];

                if (board[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int back = (dir + 2) % 4;
                int nx = r + dx[back];
                int ny = c + dy[back];
                if (board[nx][ny] == 1) break;
                r = nx;
                c = ny;
            }
        }

        System.out.println(answer);
    }
}