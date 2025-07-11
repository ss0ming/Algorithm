class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] demage = new int[board.length+1][board[0].length+1];
        
        for (int i=0; i<skill.length; i++) {
            int type = skill[i][0];
            int degree = skill[i][5];
            
            int a = skill[i][1];
            int b = skill[i][2];
            int c = skill[i][3];
            int d = skill[i][4];
            
            if (type == 1) {
                demage[a][b] -= degree;
                demage[a][d+1] += degree;
                demage[c+1][b] += degree;
                demage[c+1][d+1] -= degree;
            } else if (type == 2) {
                demage[a][b] += degree;
                demage[a][d+1] -= degree;
                demage[c+1][b] -= degree;
                demage[c+1][d+1] += degree;
            }
        }
        
        for (int x=0; x<demage.length; x++) {
                for (int y=0; y<demage[0].length; y++) {
                    if (y == 0) continue;
                    demage[x][y] += demage[x][y-1];
                }
            }
            
            for (int x=0; x<demage.length; x++) {
                if (x == 0) continue;
                for (int y=0; y<demage[0].length; y++) {
                    demage[x][y] += demage[x-1][y];
                }
            }
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                board[i][j] += demage[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}