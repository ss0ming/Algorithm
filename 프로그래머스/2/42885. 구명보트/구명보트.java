import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length-1;
        
        while (i <= j) {
            if (i == j) {
                answer++;
                break;
            }
            
            int p1 = people[i];
            int p2 = people[j];
            
            if (p1 + p2 <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            
            answer++;
        }
        
        return answer;
    }
}