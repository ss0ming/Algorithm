import java.util.*;

class Solution {
    
    static List<Integer>[] tree;
    static Map<Integer, Integer> sw = new HashMap<>();
    static int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        // 초기화 -> 트리 만들기
        int n = info.length;
        
        tree = new ArrayList[n];
        for (int i=0; i<n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            int parent = e[0];
            int child = e[1];
            tree[parent].add(child);
        }
        
        for (int i=0; i<info.length; i++) {
            sw.put(i, info[i]);
        }
        System.out.println(sw);
        
        // 루트부터 노드 탐새
        dfs(0, 1, 0, new ArrayList<>());
        
        return answer;
    }
    
    static void dfs(int node, int sheep, int wolf, List<Integer> nextNodes) {
        answer = Math.max(answer, sheep);

        List<Integer> next = new ArrayList<>(nextNodes);
        next.remove(Integer.valueOf(node)); // 현재 방문한 노드는 제거
        next.addAll(tree[node]);            // 현재 노드의 자식은 추가

        for (int nxt : next) {
            int ns = sheep;
            int nw = wolf;

            if (sw.get(nxt) == 0) ns++;
            else nw++;

            // 조건 위반 시 skip
            if (ns <= nw) continue;

            dfs(nxt, ns, nw, next);
        }
    }

}