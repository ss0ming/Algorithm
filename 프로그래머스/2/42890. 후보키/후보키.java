import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    static int c;
    static int r;
    static String[][] rlt;
    static List<ArrayList<Integer>> keys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        visited = new boolean[relation[0].length];
        rlt = relation;
        c = relation[0].length;
        r = relation.length;
        
        for (int i=1; i<=relation.length; i++) {
            choose(0, i, 0);
        }
        
        return answer;
    }
    
    private static void choose(int depth, int end, int idx) {
        if (depth == end) {
            check();
            return;
        }
        
        for (int i=idx; i<visited.length; i++) {
            visited[i] = true;
            choose(depth+1, end, i+1);
            visited[i] = false;
        }
    }
    
    private static void check() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<c; i++) {
            if (visited[i]) list.add(i);
        }
        
        for (ArrayList<Integer> key : keys) {
            int cnt = 0;
            for (int next : key) {
                if (list.contains(next)) cnt++;
            }
            if (cnt == key.size()) return;
        }
        
        Set<String> set = new HashSet<>();
        for (int i=0; i<rlt.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<list.size(); j++) {
                sb.append(rlt[i][list.get(j)]);
            }
            String res = sb.toString();
            if (set.contains(res)) return;
            set.add(res);
        }
        
        keys.add(list);
        answer++;
    }
}