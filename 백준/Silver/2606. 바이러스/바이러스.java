import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int answer = 0;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i=0; i<t; i++) {
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

    public static void dfs(int now) {
        for (int i=1; i<arr.length; i++) {
            if (arr[now][i] == 1 && !visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i);
            }
        }
    }
}