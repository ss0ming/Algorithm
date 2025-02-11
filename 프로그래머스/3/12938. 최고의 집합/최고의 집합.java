import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int q = s / n;
        int r = s % n;
        
        if (q == 0) {
            int[] res = {-1};
            return res;
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, q);
        
        for (int i=answer.length-1; i>=answer.length-r; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}