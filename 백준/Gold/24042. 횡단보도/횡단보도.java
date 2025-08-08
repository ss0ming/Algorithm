import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    @SuppressWarnings("unchecked")
    static List<Node>[] graph;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, i, i));
            graph[b].add(new Node(a, i, i));
        }

        solution();
    }

    private static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.t, b.t)
        );
        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        long[] dis = new long[N+1];
        for (int i=2; i<=N; i++) {
            dis[i] = INF;
        }

        for (Node tmp : graph[1]) {
            dis[tmp.v] = tmp.idx;
            pq.add(new Node(tmp.v, dis[tmp.v], tmp.idx));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == N) {
                System.out.println(cur.t);
                break;
            }

            if (visited[cur.v]) {
                continue;
            }

            visited[cur.v] = true;

            for (Node next : graph[cur.v]) {
                long curT = (cur.t - next.idx);

                if (curT < 0) {
                    curT = 0;
                } else {
                    curT = curT / M;
                    curT = curT + 1;
                }

                if (dis[next.v] > next.idx + (curT * M)) {
                    dis[next.v] = next.idx + (curT * M);
                    pq.add(new Node(next.v, dis[next.v], next.idx));
                }
            }
        }
    }

    public static class Node {
        int v;
        long t;
        long idx;

        Node(int v, long t, long idx) {
            this.v = v;
            this.t = t;
            this.idx = idx;
        }
    }
}