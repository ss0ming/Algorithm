import java.util.*;

class Solution {
    
    static List<List<Integer>> graph;
    static int[] answer = new int[4];
    static boolean[] visited;
    static int[] inComing;
    
    public int[] solution(int[][] edges) {       
        // init
        init(edges);
        
        // 생성지점 찾기
        findStart();
        
        // 8자 모양 찾기
        countEight();
        
        // 막대 모양 찾기
        countStick();
        
        // 도넛 모양 찾기
        answer[1] = graph.get(answer[0]).size() - answer[2] - answer[3];
        
        return answer;
    }
    
    public static void countStick() {
        int count = 0;
        for (int i=1; i<graph.size(); i++) {
            if (visited[i]) continue;
            if (graph.get(i).size() == 0 && inComing[i] > 0) {
                count++;
            }
        }
        answer[2] = count;
    }
    
    public static void countEight() {
        int count = 0;
        for (int i=1; i<graph.size(); i++) {

            if (graph.get(i).size() >= 2 && inComing[i] >= 2) {

                visited[i] = true;
                count++;
            }
        }
        answer[3] = count;
    }
     
    public static void init(int[][] edges) {
        int maxV = 0;
        for (int[] edge : edges) {
            maxV = Math.max(maxV, Math.max(edge[0], edge[1]));
        }
        
        graph = new ArrayList<>(maxV+1);
        visited = new boolean[maxV+1];
        inComing = new int[maxV+1];
        
        for (int i = 0; i <= maxV; i++) {
            graph.add(new LinkedList<>());
        }
        
        for (int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            inComing[edges[i][1]]++;
        }
    }
    
    public static void findStart() {
        for (int i=1; i<inComing.length; i++) {
            if (inComing[i] == 0 && graph.get(i).size() >= 2) {
                answer[0] = i;
                break;
            }
        }
    }
}