import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int beforeN = arr[0];
        list.add(arr[0]);
        
        for (int i=1; i<arr.length; i++) {
            if (beforeN != arr[i]) {
                list.add(arr[i]);
            }
            beforeN = arr[i];
        }
        
        answer = new int[list.size()];
        int idx = 0;
        
        for (Integer n : list) {
            answer[idx++] = n;
        }

        return answer;
    }
}