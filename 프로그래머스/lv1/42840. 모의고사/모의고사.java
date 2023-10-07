import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == supoja1[i%5]) {
                cnt[0]++;
            }
            if (answers[i] == supoja2[i%8]) {
                cnt[1]++;
            }
            if (answers[i] == supoja3[i%10]) {
                cnt[2]++;
            }
        }
        
        int maxScore = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<cnt.length; i++) {
            if (cnt[i] == maxScore) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}