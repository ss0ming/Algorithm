import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new LinkedList<>());
        } 

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, W));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[] answer = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[from] = 0;

        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(from, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (answer[cur.to] < cur.w) continue;

            for (Node next : graph.get(cur.to)) {
                if (answer[next.to] > answer[cur.to] + next.w) {
                    answer[next.to] = answer[cur.to] + next.w;
                    pq.add(new Node(next.to, answer[next.to]));
                }
            }
        }

        System.out.println(answer[to]);
    }
}