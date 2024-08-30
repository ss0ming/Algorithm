import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int answer = 101;

        arr = new int[20][20];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) arr[x][y] = 2;
            else arr[x][y] = 3;

            if (checkGame(x, y, arr[x][y])) {
                answer = Math.min(answer, i);
            }
        }
        if (answer == 101) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    public static boolean checkGame(int x, int y, int color) {
        int cnt = 1;

        for (int i=0; i<8; i++) {

            if (i % 2 == 0) {
                cnt = 1;
            }

            for (int j=1; j<6; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (isPromising(nx, ny) && arr[nx][ny] == color) cnt++;
                else if (isPromising(nx, ny) && arr[nx][ny] != color) break;
            }

            if (i % 2 != 0 && cnt == 5) {
                return true;
            }
        }
        if (cnt == 5) return true;
        return false;
    }

    public static boolean isPromising(int x, int y) {
        return x >= 1 && x <= 19 && y >= 1 && y <= 19;
    }
}