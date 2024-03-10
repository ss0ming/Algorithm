import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> q = new Stack<>();
        
        for (int i=0; i<moves.length; i++) {
            int n = moves[i] - 1;
            
            for (int j=0; j<board.length; j++) {
                int now = board[j][n];
                
                if (now != 0) {
                    
                    if (q.isEmpty()) {
                        q.add(now);
                    } else if (q.peek() != now) {
                        q.add(now);
                    } else if (q.peek() == now) {
                        q.pop();
                        answer += 2;
                    }
                    
                    
                    
                    board[j][n] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}