import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        String[][] board = new String[5][5];
        
        for (int p=0; p<places.length; p++) {
            List<int[]> peoples = new ArrayList<>();
            for (int i=0; i<5; i++) {
                board[i] = places[p][i].split("");
                for (int j=0; j<5; j++) {
                    if (board[i][j].equals("P")) {
                        peoples.add(new int[]{i, j});
                    }
                }   
            }
            
            // 맨해튼 거리 확인
            // 2이하면 확인하기
            // 아니면 넘어가기
            // 바로
            int len = peoples.size();
            for (int i=0; i<len-1; i++) {
                for (int j=i+1; j<len; j++) {
                    int[] p1 = peoples.get(i);
                    int[] p2 = peoples.get(j);
                    
                    if ((Math.abs(p1[0] - p2[0])) + (Math.abs(p1[1] - p2[1])) > 2) continue;
                    if (p1[0] == p2[0]) {
                        if (!board[p1[0]][p1[1] + 1].equals("X")) {
                            answer[p] = 0;
                            break;
                        }
                    } else if (p1[1] == p2[1]) {
                        if (!board[p1[0] + 1][p1[1]].equals("X")) {
                            answer[p] = 0;
                            break;
                        }
                    } else {
                        if (p1[1] < p2[1] && !(board[p1[0] + 1][p1[1]].equals("X") && board[p1[0]][p1[1] + 1].equals("X"))) {
                            answer[p] = 0;
                            break;
                        } else if (p1[1] > p2[1] && !(board[p1[0] + 1][p1[1]].equals("X") && board[p1[0]][p1[1] - 1].equals("X"))) {
                            answer[p] = 0;
                            break;
                        }
                    }
                }
                if (answer[p] == 0) break;
            }
        }
        

        
        return answer;
    }
}