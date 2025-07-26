import java.io.*;
import java.util.*;

class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[V+1];
            for (int v=0; v<=V; v++) {
                graph[v] = new ArrayList<>();
            }

            for (int e=0; e<E; e++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean flag = true;
            int[] color = new int[V+1];
            for (int v=1; v<=V; v++) {
                if (color[v] == 0) {
                    color[v] = 1;
                    flag = bfs(v, graph, color);
                }
                if (!flag) break;
            }
            
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int s, List<Integer>[] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if(color[cur] == color[next]) {
                    return false;
                }
                if (color[next] == 0) {
                    color[next] = color[cur] * (-1);
                    q.add(next);
                }
            }
        }

        return true;
    }
}