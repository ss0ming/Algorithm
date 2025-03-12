import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x = -1;
        int y = 0;
        int idx = 1;
        int seq = 0;
        
        for (int i=n; i>0; i--) {
            if (seq % 3 == 0) {
                for (int k=0; k<i; k++) {
                    x++;
                    arr[x][y] = idx;
                    idx++;
                }
            } else if (seq % 3 == 1) {
                for (int k=0; k<i; k++) {
                    y++;
                    arr[x][y] = idx;
                    idx++;
                }
            } else if (seq % 3 == 2) {
                for (int k=0; k<i; k++) {
                    x--;
                    y--;
                    arr[x][y] = idx;
                    idx++;
                }
            }
            seq++;
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<i+1; j++) {
                answer.add(arr[i][j]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}