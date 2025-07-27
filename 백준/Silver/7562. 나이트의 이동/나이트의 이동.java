import java.io.*;
import java.util.*;

class Main {

    static int[] dx = {-1, -2, 1, 2, -2, -1, 2, 1};
    static int[] dy = {-2, -1, -2, -1, 1, 2, 1, 2};
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
            } else {
                System.out.println(bfs(x1, y1, x2, y2));
            }
        }
    }

    private static int bfs(int x1, int y1, int x2, int y2) {
        int[][] board = new int[size][size];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1, 0});
        board[x1][y1] = -1;
        boolean flag = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i=0; i<dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny) || board[nx][ny] != 0) continue;
                board[nx][ny] = cur[2] + 1;
                q.add(new int[]{nx, ny, cur[2] + 1});
                if (nx == x2 && ny == y2) {
                    flag = true;
                    break;
                }
            }

            if (flag) break;
        }

        return board[x2][y2];
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}