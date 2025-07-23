import java.util.*;

class Solution {
    
    static int INF = 10_000_001;
    static List<Node>[] graph;
    
    public static class Node implements Comparable<Node> {
        int next;
        int intensity;
        
        public Node(int next, int intensity) {
            this.next = next;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Node o) {
            return intensity - o.intensity;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {INF, INF};
        graph = new ArrayList[n+1];
        init(paths);

        List<Integer> smts = new ArrayList<>();
        for (int summit : summits) {
            smts.add(summit);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] tmp = new int[n+1];
        Arrays.fill(tmp, INF);
        
        for (int i=0; i<gates.length; i++) {
            pq.add(new Node(gates[i], 0));
        }
        
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.next;
            
            if (curNode.intensity > tmp[cur]) continue;  
            if (smts.contains(cur)) continue;
            
            for (Node nextNode : graph[cur]) {
                int max = Math.max(nextNode.intensity, curNode.intensity);
                if (max < tmp[nextNode.next]) {
                    tmp[nextNode.next] = max;
                    pq.add(new Node(nextNode.next, max));
                }
            }
        }
        
        Collections.sort(smts);
        for (int i : smts) {
            if (tmp[i] < answer[1]) {
                answer[0] = i;
                answer[1] = tmp[i];
            }
        }
        
        return answer;
    }
    
    private static void init(int[][] paths) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int p=0; p<paths.length; p++) {
            int i = paths[p][0];
            int j = paths[p][1];
            int w = paths[p][2];
            
            graph[i].add(new Node(j, w));
            graph[j].add(new Node(i, w));
        }
    }
}