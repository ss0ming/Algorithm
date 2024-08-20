import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static int answer = 0;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int x) {
        for (int i=1; i<=N; i++) {
            if (arr[x][i] == 1 && !visited[i]) {
                answer++;
                visited[i] = true;
                dfs(i);
            }

        }
    }
}