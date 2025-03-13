import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int workingServer = 0;
        
        
        for (int i=0; i<players.length; i++) {
            if (!q.isEmpty() && q.peek()[0] == i) {
                workingServer -= q.poll()[1];
            }
            
            int needServer = players[i] / m; // 필요한 서버 계산
            int moreServer = needServer - workingServer; // 현재 더 필요한 서버의 대수
            if (moreServer > 0) {
                workingServer += moreServer;
                answer += moreServer;
                q.add(new int[]{i+k, moreServer});
            }
        }
        
        return answer;
    }
}