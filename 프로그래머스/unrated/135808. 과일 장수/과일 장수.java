import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int p = k;
        int cnt = 1;
        
        for (int i=score.length-1; i>=0; i--) {
            if (p > score[i]) {
                p = score[i];
            }
            if (cnt == m) {
                answer += (p * m);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        return answer;
    }
}