import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowCost = now[1];

            if (dist[nowNode] < nowCost) continue;

            for (int[] next : graph.get(nowNode)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (dist[nextNode] > nowCost + nextCost) {
                    dist[nextNode] = nowCost + nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int answer = 0;
        for (int d : dist) {
            if (d <= K) answer++;
        }

        return answer;
    }
}