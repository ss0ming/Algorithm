import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            String longToBin = Long.toString(numbers[i], 2);
            
            int lastIndex = longToBin.lastIndexOf("0");
            
            if (lastIndex == -1) {
                String tmp = "10" + longToBin.substring(1);
                answer[i] = Long.parseLong(tmp, 2);
            } else if (lastIndex == longToBin.length()-1) {
                answer[i] = numbers[i] + 1;
            } else {
                String tmp = longToBin.substring(0, lastIndex) + "10" + longToBin.substring(lastIndex+2);
                answer[i] = Long.parseLong(tmp, 2);
            }
        }
        
        return answer;
    }
}