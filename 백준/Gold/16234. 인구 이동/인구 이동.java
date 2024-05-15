import java.io.*;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[][] arr;
    static boolean[][] visited;
    static List<int[]> list;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    static int move() {
        int result = 0;
        while (true) { // 인구 이동 없을 때까지 반복
            visited = new boolean[n][n];
            boolean isMove = false;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (visited[i][j]) continue;
                    int sum = bfs(i, j); // 방문하지 않은 부분부터 연합 나라 찾기

                    if (list.size() > 1) {
                        isMove = true;
                        changePopulation(sum);
                    }
                }
            }

            if (!isMove) return result;
            result++;
        }

    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = arr[x][y];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPromising(nx, ny) && !visited[nx][ny]) {
                    int tmp = Math.abs(arr[now[0]][now[1]] - arr[nx][ny]); // 인구 차이

                    if (tmp >= l && tmp <= r) { // 인구 차이가 조건에 만족하면
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                        list.add(new int[] { nx, ny });
                        sum += arr[nx][ny];
                    }
                }
            }
        }

        return sum;
    }

    static boolean isPromising(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            arr[x][y] = avg;
        }
    }
}