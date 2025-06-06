import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n+1];
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new LinkedList<>());
        }
        
        for (int i=0; i<edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        q.add(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph.get(cur)) {
                if (visited[next]) continue;
                if (dist[next] == 0) {
                    dist[next] = dist[cur] + 1;
                } else {
                    dist[next] = Math.min(dist[cur] + 1, dist[next]);
                } 
                q.add(next);
                visited[next] = true;
                max = Math.max(max, dist[next]);
            }
        }
        
        for (int i=2; i<=n; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}