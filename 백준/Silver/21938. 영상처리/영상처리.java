import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];
        int idx = 0;
        int sum = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M*3; j++) {
                int p = Integer.parseInt(st.nextToken());
                sum += p;
                if (j%3 == 2) {

                    arr[i][idx++] = sum/3;
                    sum = 0;
                }
            }
            idx = 0;
        }

        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=0; i<arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= T) {
                    arr[i][j] = 255;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j] == 255 && visited[i][j] != 1) {
                    answer++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs (int i, int j)  {
        Queue<Pos> q = new LinkedList<>();
        visited[i][j] = 1;
        q.add(new Pos(i, j));

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int k=0; k<4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (check(nx, ny)) continue;
                visited[nx][ny] = 1;
                q.add(new Pos(nx, ny));
            }
        }
    }

    public static boolean check (int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] == 1 || arr[nx][ny] == 0;
    }

}
class Pos {
    int x, y;

    public Pos (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
