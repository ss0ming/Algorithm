import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N+1][N+1];
            boolean[] visited = new boolean[N+1];

            for (int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            bfs(arr, visited);
        }
    }

    public static void bfs(int[][] arr, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int n = q.poll();
            result++;

            for (int i=1; i<arr.length; i++) {
                if (arr[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        System.out.println(result-1);
    }

}