import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (!list.contains(numbers[i] + numbers[j])) {
                    list.add(numbers[i] + numbers[j]);    
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        
        for (Integer n : list) {
            answer[idx++] = n;
        }
        
        Arrays.sort(answer);
         
        return answer;
    }
}