import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> set = new HashSet<>();
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];

        for (int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "");
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int x, int y, int cnt, String s) {
        if (cnt == 6) {
            set.add(Integer.parseInt(s));
            return;
        }

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, cnt+1, s.concat(Integer.toString(arr[nx][ny])));
            }
        }
    }
}