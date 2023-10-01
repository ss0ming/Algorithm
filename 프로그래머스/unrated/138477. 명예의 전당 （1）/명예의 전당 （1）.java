import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i=0; i<score.length; i++) {
            list.add(score[i]);
            Collections.sort(list, Collections.reverseOrder());
            if (i >= k) {
                list.remove(k);
                answer[i] = list.get(k-1);
            } else {
                answer[i] = list.get(i);
            }
            
        }
        
        return answer;
    }
}