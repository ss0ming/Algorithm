import java.util.*;

class Solution {
    public int solution(int storey) {
        // 5 이하면 10 나누고 나머지 더하고
        // 5 이상이면 10 나누고 하나 더하고 10-현재 숫자 더하고
        int answer = 0;
        
        while (storey > 0) {
            int tmp = storey % 10;
            storey /= 10;
            
            if (tmp < 5) {
                answer += tmp;
            } else if (tmp > 5) {
                answer += (10 - tmp);
                storey++;
            } else {
                if (storey % 10 >= 5) {
                    answer += 10- tmp;
                    storey++;
                } else {
                    answer += tmp;
                }
            }
        }
        
        return answer;
    }
}