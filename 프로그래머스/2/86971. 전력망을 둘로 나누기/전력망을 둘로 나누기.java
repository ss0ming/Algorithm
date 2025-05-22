import java.util.*;

class Solution {
    
    static Map<Integer, List<Integer>> map = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        int answer = 99;
        
        for (int i=0; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i=0; i<wires.length; i++) {
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }

        for (int i=0; i<wires.length; i++) {
            boolean[] visited = new boolean[n+1];
            map.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            map.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            int c1 = bfs(visited);
            int c2 = n - c1;
            if (answer > Math.abs(c1-c2)) {
                answer = Math.abs(c1-c2);
                
            }
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }
        
        return answer;
    }
    
    private static int bfs(boolean[] visited) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();  
        q.add(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> list = map.get(cur);
            
            for (int i=0; i<list.size(); i++) {
                int next = list.get(i);
                if (visited[next]) continue;
                q.add(next);
                visited[next] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}