import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static String[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        visited = new boolean[N][M];

        int ix = -1;
        int iy = -1;

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            String[] tmp = input.split("");
            map[i] = tmp;
            for (int j=0; j<M; j++) {
                if (map[i][j].equals("I")) {
                    ix = i;
                    iy = j;
                } else if (map[i][j].equals("X")) {
                    visited[i][j] = true;
                }
            }
        }

        visited[ix][iy] = true;
        bfs(ix, iy);

        if (answer == 0) System.out.println("TT");
        else System.out.println(answer);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int curX = tmp[0];
            int curY = tmp[1];

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isPromising(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    if (map[nx][ny].equals("P")) {
                        answer++;
                    }
                }
            }
        }


    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}