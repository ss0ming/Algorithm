class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] visited = new int[section.length];
        
        for (int i=0; i<section.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            answer++;
            for (int j=i+1; j<section.length; j++) {
                if (section[i]+m-1 >= section[j]) {
                    visited[j] = 1;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}