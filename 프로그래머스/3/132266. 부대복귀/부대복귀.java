import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dist[destination] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}