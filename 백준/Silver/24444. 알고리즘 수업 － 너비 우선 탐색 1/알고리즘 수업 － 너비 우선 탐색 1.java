import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int[] answer;
    static int idx = 1;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        answer = new int[N+1];

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i=1; i<N+1; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(int n) {

        visited[n] = 1;
        answer[n] = idx++;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);

        while (!q.isEmpty()) {
            n = q.poll();

            for (int w : graph.get(n)) {
                if (visited[w] == 0) {
                    visited[w] = 1;
                    answer[w] = idx++;
                    q.add(w);
                }
            }
        }
    }
}