import java.io.*;
import java.util.*;



public class Main {

    static List<Node>[] list;
    static int[] dist;

    private static class Node {
        int v;
        int dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        dist = new int[N+1];

        for (int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(start);

        for (int i=1; i<=N; i++) {
            if (dist[i] > M*10) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.dis, o2.dis)));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.v] < now.dis) continue;

            for (Node next : list[now.v]) {
                if (dist[next.v] > now.dis + next.dis) {
                    dist[next.v] = now.dis + next.dis;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}