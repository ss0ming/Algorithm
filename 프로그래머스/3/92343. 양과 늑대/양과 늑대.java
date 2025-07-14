import java.util.*;

class Solution {
    static int answer = 0;
    static List<Integer>[] nodes;
    static int [] INFO;
    
    public int solution(int[] info, int[][] edges) {
        INFO = info;
        nodes = new ArrayList[info.length];
        for (int i=0; i<info.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int i=0; i<edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            nodes[parent].add(child);
        }
        
        List<Integer> notVisited = new ArrayList<>();
        notVisited.add(0);
        dfs(0, notVisited, 0, 0);
        
        return answer;
    }
    
    private void dfs(int now, List<Integer> notVisited, int lamps, int wolfs) {
        if (INFO[now] == 0) {
            lamps++;
        } else {
            wolfs++;
        }
        
        if (lamps <= wolfs) {
            return;
        }
        
        answer = Math.max(answer, lamps);
        notVisited.remove(Integer.valueOf(now));
        notVisited.addAll(nodes[now]);
        
        for (int i : notVisited) {
            List<Integer> next = new ArrayList<>(notVisited);
            dfs(i, next, lamps, wolfs);
        }
    }
}