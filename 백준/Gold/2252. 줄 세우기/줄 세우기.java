import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N+1];
        int[] degree = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            degree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int n = q.poll();

            for (int l : list[n]) {
                degree[l]--;
            }

            for (int i=1; i<=N; i++) {
                if (!visited[i] && degree[i] == 0) {
                    q.add(i);
                    visited[i] = true;
                }
            }

            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}