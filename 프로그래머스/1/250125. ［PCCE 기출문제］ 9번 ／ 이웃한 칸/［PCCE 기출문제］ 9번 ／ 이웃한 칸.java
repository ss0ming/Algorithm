class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i=0; i<4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];
            
            if (isPromising(x, y, board) && board[h][w].equals(board[x][y])) {
                answer++;
            }
        }
            
        return answer;
    }
    
    public static boolean isPromising(int x, int y, String[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y<board[0].length;
    }
}