import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int j=0; j<board[0].length; j++) {
            map.put(j+1, new Stack<>());
            Stack tmp = map.get(j+1);
            for (int i=board.length-1; i>=0; i--) {
                if (board[i][j] == 0) continue;
                tmp.add(board[i][j]);
            }
        }
        
        for (int i=0; i<moves.length; i++) {
            int m = moves[i];
            Stack s = map.get(m);
            if (s.isEmpty()) continue;
            int pick = (int) s.pop();
            
            if (basket.isEmpty()) {
                basket.add(pick);
            } else {
                if (basket.peek() == pick) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.add(pick);
                }
            }
        }
        
        return answer;
    }
}