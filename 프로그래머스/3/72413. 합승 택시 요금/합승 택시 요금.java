import java.util.*;

class Vertex {
    int idx;
    int cost;
    
    public Vertex (int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

class Solution {
    
    static List<Vertex>[] list;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n+1];
        for (int i=1; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i=0; i<fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];
            
            list[start].add(new Vertex(end, weight));
            list[end].add(new Vertex(start, weight));
        }
        
        int[] together = dijstra(s);
        for (int i=1; i<list.length; i++) {
            int[] alone = dijstra(i);
            // System.out.println(Arrays.toString(alone));
            answer = Math.min(answer, together[i] + alone[a] + alone[b]);
        }

        return answer;
    }
    
    private static int[] dijstra(int start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] dist= new int[list.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Vertex(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Vertex now = pq.poll();
            if (now.cost > dist[now.idx]) continue;
            
            for (int i=0; i<list[now.idx].size(); i++) {
                int nv = list[now.idx].get(i).idx;
                int nDist = dist[now.idx] + list[now.idx].get(i).cost;
                
                if (dist[nv] > nDist) {
                    dist[nv] = nDist;
                    pq.add(new Vertex(nv, nDist));
                }
            }
        }
        return dist;
    }
}