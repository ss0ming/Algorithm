import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, List<Integer>> map;
    static int k;
    static int[] visited;
    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new int[n+1];

        for (int i=1; i<n+1; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            List<Integer> list = map.get(u);
            list.add(v);
            map.put(u, list);
        }

        bfs(x, 0);

        boolean bool = false;
        for (int i=1; i<n+1; i++) {
            if (visited[i] == k) {
                System.out.println(i);
                bool = true;
            }
        }

        if (!bool) System.out.println("-1");
    }

    public static void bfs(int start, int d) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, d});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int n = now[0];
            int dis = now[1];

            List<Integer> list = map.get(n);

            for (int next : list) {
                if (visited[next] != 0 || next == start) continue;
                visited[next] = dis + 1;
                q.add(new int[]{next, dis + 1});
            }
        }
    }
}