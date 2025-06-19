import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        
        int n = 1;
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                arr[i][j] = n++;
            }
        }
        
        for (int i=0; i<queries.length; i++) {
            int[] cur = queries[i];
            Queue<Integer> q = new LinkedList<>();
            q.add(arr[cur[0]+1][cur[1]]);
            int min = arr[cur[0]+1][cur[1]];
            
            // 오른쪽으로
            for (int k=cur[1]; k<=cur[3]; k++) {
                int now = arr[cur[0]][k];
                arr[cur[0]][k] = q.poll();
                q.add(now);
                min = Math.min(min, now);
            }
            
            // 아래로
            for (int k=cur[0]+1; k<=cur[2]; k++) {
                int now = arr[k][cur[3]];
                arr[k][cur[3]] = q.poll();
                q.add(now);
                min = Math.min(min, now);
            }
            
            // 왼쪽으로
            for (int k=cur[3]-1; k>=cur[1]; k--) {
                int now = arr[cur[2]][k];
                arr[cur[2]][k] = q.poll();
                q.add(now);
                min = Math.min(min, now);
            }
            
            // 위로
            // 0  1  2  3
            // x1 y1 x2 y2
            for (int k=cur[2]-1; k>=cur[0]; k--) {
                int now = arr[k][cur[1]];
                arr[k][cur[1]] = q.poll();
                q.add(now);
                min = Math.min(min, now);
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
}