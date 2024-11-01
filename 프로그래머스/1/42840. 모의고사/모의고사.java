import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
        for (int i=0; i<answers.length; i++) {
            int ans = answers[i];
            if (ans == one[i%5]) {
                answer[0]++;
            }
            if (ans == two[i%8]) {
                answer[1]++;
            }
            if (ans == three[i%10]) {
                answer[2]++;
            }
        }
       
        int max = Arrays.stream(answer).max().orElse(0);
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (answer[i] == max) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}