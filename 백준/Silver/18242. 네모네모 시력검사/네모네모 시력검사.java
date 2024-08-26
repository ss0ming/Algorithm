import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[][] arr = new String[N][M];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            arr[i] = input.split("");
        }

        boolean flag = false;
        int x = -1;
        int y = -1;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j].equals(".")) continue;
                x = i;
                y = j;
                flag = true;
                break;
            }
            if (flag) break;
        }

        int dir = 0;

        while (true) {
            x = x + dx[dir];
            y = y + dy[dir];

            if (!isPromising(x, y)) {
                x = x - dx[dir];
                y = y - dy[dir];
                dir++;
                continue;
            }

            if (arr[x][y].equals("#")) continue;

            if (dir == 3) break;

            if (isPromising(x + dx[dir], y + dy[dir]) && arr[x + dx[dir]][y + dy[dir]].equals("#")) {
                break;
            }

            x = x - dx[dir];
            y = y - dy[dir];

            dir++;
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "UP");
        map.put(1, "RIGHT");
        map.put(2, "DOWN");
        map.put(3, "LEFT");

        System.out.println(map.get(dir));
    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && x <N && y >= 0 && y < M;
    }
}