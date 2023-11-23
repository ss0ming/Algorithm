import java.io.*;
import java.util.*;

public class Main {

    static int[] visited = new int[100_001];
    static int K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited[N] = 1;
        bfs(N);

        System.out.println(visited[K] - 1);
    }

    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            int n = q.poll();

            if (n == K) {
                return;
            }
            if (n-1 >= 0 && visited[n-1] == 0) {
                visited[n-1] = (visited[n] + 1);
                q.add(n-1);
            }

            if (n+1 <= 100000 && visited[n+1] == 0) {
                visited[n+1] = (visited[n] + 1);
                q.add(n+1);
            }

            if (n*2 <= 100000 && visited[n*2] == 0) {
                visited[n*2] = (visited[n] + 1);
                q.add(n*2);
            }

        }
    }

}