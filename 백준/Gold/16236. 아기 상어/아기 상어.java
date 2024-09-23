import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; // 좌 오 오른 아래
    static int[] dy = {0, -1, 0, 1};
    static int size = 2;
    static int answer = 0;
    static int[] position = new int[2];
    static int eatFishNum = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        arr[position[0]][position[1]] = 0;
        findFish();

        System.out.println(answer);
    }

    public static void findFish() {
        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean isFinish = bfs(visited);
            eatFishNum++;
            if (eatFishNum == size) {
                size++;
                eatFishNum = 0;
            }
            if (isFinish) break;;
        }
    }

    public static boolean bfs(boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{position[0], position[1], 0});
        visited[position[0]][position[1]] = true;

        int minX = -1;
        int minY = -1;
        int minDis = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (arr[now[0]][now[1]] != 0 && arr[now[0]][now[1]] < size) {
                if (minDis > now[2]) {
                    minX = now[0];
                    minY = now[1];
                    minDis = now[2];
                } else if (now[2] == minDis) {
                    if (now[0] < minX || (now[0] == minX && now[1] < minY)) {
                        minX = now[0];
                        minY = now[1];
                    }
                }
            }

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPromising(nx, ny) && !visited[nx][ny] && arr[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        if (minX == -1) {
            return true;
        }

        arr[minX][minY] = 0;
        answer += minDis;
        position[0] = minX;
        position[1] = minY;

        return false;
    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}