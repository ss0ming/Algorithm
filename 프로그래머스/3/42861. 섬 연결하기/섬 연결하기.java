import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new LinkedList<>());
        }
        
        for (int i=0; i<costs.length; i++) {
            int u = costs[i][0];
            int v = costs[i][1];
            int w = costs[i][2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int cnt = 0;
        boolean[] visited = new boolean[n];
        
        visited[0] = true;
        for (int[] g : graph.get(0)) {
            pq.add(new int[]{g[0], g[1]});
        }
        
        while(cnt < n-1) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            cnt++;
            
            answer += cur[1];
            for (int[] g : graph.get(cur[0])) {
                if (visited[g[0]]) continue;
                pq.add(new int[]{g[0], g[1]});
                
            }
        }
        
        return answer;
    }
}