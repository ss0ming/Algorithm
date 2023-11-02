import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        for (int i=0; i<=N; i++) {
            Collections.sort(list.get(i));
        }

        boolean[] visited = new boolean[N+1];
        boolean[] visited2 = new boolean[N+1];
        visited[V] = true;
        visited2[V] = true;

        System.out.print(V + " ");
        dfs(V, visited);
        System.out.println();
        bfs(V, visited2);
    }

    public static void dfs (int node, boolean[] visited) {
        for (int i=0; i<list.get(node).size(); i++) {
            int cur = list.get(node).get(i);
            if (visited[cur]) continue;
            System.out.print(cur + " ");
            visited[cur] = true;
            dfs(cur, visited);
        }
    }

    public static void bfs (int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i=0; i<list.get(cur).size(); i++) {
                int nextNode = list.get(cur).get(i);
                if (visited[nextNode]) continue;
                q.offer(nextNode);
                visited[nextNode] = true;
            }
        }

        System.out.println(sb);
    }
}