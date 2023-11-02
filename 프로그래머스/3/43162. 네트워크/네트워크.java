class Solution {
    
    public static boolean[] visited;
    public static int answer;
    public static int[][] arr;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        
        arr = new int[computers.length][computers[0].length];
        visited = new boolean[n];
        
        for (int i=0; i<computers.length; i++) {
            for (int j=0; j<computers[i].length; j++) {
                arr[i][j] = computers[i][j];
            }
        }
        
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i);
            answer++;
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        for (int i=0; i<arr[node].length; i++) {
            if (visited[i] == true || arr[node][i] == 0) continue;
            visited[i] = true;
            dfs(i);
        }
    }
}