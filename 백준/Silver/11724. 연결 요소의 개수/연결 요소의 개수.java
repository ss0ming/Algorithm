import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = true;
            arr[v][u] = true;
        }

        int cnt = 0;
        for (int i=1; i<arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            bfs(i);
            cnt++;
        }

        System.out.println(cnt);

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i=1; i< arr.length; i++) {
                if (!arr[now][i]) continue;
                if (visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}