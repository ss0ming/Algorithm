import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int xl = board.length;
        int yl = board[0].length;
        
        if (xl == 1) {
            for (int i=0; i<xl; i++) {
                if (board[i][0] == 1) {
                    return 1;
                }
                return 0;
            }
        }
        
        if (yl == 1) {
            for (int i=0; i<yl; i++) {
                if (board[0][i] == 1) {
                    return 1;
                }
                return 0;
            }
        }

        for (int i=1; i<xl; i++) {
            for (int j=1; j<yl; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        
        return answer*answer;
    }
}