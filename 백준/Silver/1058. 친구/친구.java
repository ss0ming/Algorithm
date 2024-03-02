import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            bfs(i, arr, visited);
        }

        System.out.println(answer);
    }

    public static void bfs(int n, String[][] arr, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        int depth = 0;
        int cnt = 0;

        while (depth < 2) {
            int size = q.size();
            for (int k=0; k<size; k++) {
                int cur = q.poll();

                for (int i = 0; i < arr.length; i++) {
                    if (arr[cur][i].equals("N") || visited[i]) continue;
                    visited[i] = true;
                    cnt++;
                    q.add(i);
                }
            }
            depth++;
        }

        answer = Math.max(answer, cnt);
    }
}