class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    static int[] nums;
    
    public int solution(int[] number) {
        
        visited = new boolean[number.length];
        nums = new int[number.length];
        
        for (int i=0; i<number.length; i++) {
            nums[i] = number[i];
        }
        
        dfs(0, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int depth, int start, int sum) {
        //System.out.println(depth + " " + sum);
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        } else {
            for (int i=start; i<visited.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                sum += nums[i];
                dfs(depth+1, i+1, sum);
                visited[i] = false;
                sum -= nums[i];
            }
        }
    }
}