import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = 10;
        int right = 12;
        
        for (int i=0; i<numbers.length; i++) {
            int now = numbers[i];
            
            if (now == 1 || now == 4 || now == 7) {
                left = now;
                answer += "L";
            } else if (now == 3 || now == 6 || now == 9) {
                right = now;
                answer += "R";
            } else {
                if (now == 0) now = 11;
                int leftDis = Math.abs(now - left) / 3 + Math.abs(now - left) % 3;
                int rightDis = Math.abs(now - right) / 3 + Math.abs(now - right) % 3;
                
                if (leftDis == rightDis) {
                    if (hand.equals("left")) {
                        left = now;
                        answer += "L";
                    } else {
                        right = now;
                        answer += "R";
                    }
                } else if (leftDis < rightDis) {
                    left = now;
                    answer += "L";
                } else if (leftDis > rightDis) {
                    right = now;
                    answer += "R";
                } 
            }
        }
        
        return answer;
    }
}