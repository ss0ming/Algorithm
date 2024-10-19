import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {

    static int N;
    static ArrayList<ArrayList<Node>> arr;
    static int[] dis;
    static boolean[] check;
    static int INF = 20_000_000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        dis = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dis, INF);

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new Node(b, c));
            arr.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        if (res1 >= INF && res2 >= INF) {
            System.out.println(-1);
        } else {
            int res = Math.min(res1, res2);
            System.out.println(res);
        }
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dis, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : arr.get(cur)) {
                    if (!check[node.end] && dis[node.end] > dis[cur] + node.weight) {
                        dis[node.end] = dis[cur] + node.weight;
                        pq.add(new Node(node.end, dis[node.end]));
                    }
                }
            }
        }

        return dis[end];
    }
}