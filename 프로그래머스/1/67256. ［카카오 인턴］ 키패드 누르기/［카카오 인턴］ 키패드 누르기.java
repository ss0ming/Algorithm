import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = {3, 0};
        int[] right = {3, 2};
        int[][] keypad = new int[10][2];
        keypad[0][0] = 3;
        keypad[0][1] = 1;
        for (int i=1; i<=9; i++) {
            keypad[i][0] = i%3 == 0 ? i/3-1 : i/3;
            keypad[i][1] = i%3 == 0 ? 2 : i%3-1;
        }
        
        for (int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            
            if (num == 1 || num == 4 || num == 7) {
                answer += 'L';
                left[0] = keypad[num][0];
                left[1] = keypad[num][1];
            } else if (num == 3 || num == 6 || num == 9) {
                answer += 'R';
                right[0] = keypad[num][0];
                right[1] = keypad[num][1];
            } else {
                // 높이 차이 계산
                // 같으면? 왼손잡이인지 오른손잡이인지 확인
                // 다르면? 가까운거
                int l = Math.abs(left[0] - keypad[num][0]) + Math.abs(left[1] - keypad[num][1]);
                int r = Math.abs(right[0] - keypad[num][0]) + Math.abs(right[1] - keypad[num][1]);
                if (l == r) {
                    if (hand.equals("left")) {
                        answer += 'L';
                        left[0] = keypad[num][0];
                        left[1] = keypad[num][1];
                    } else if (hand.equals("right")) {
                        answer += 'R';
                        right[0] = keypad[num][0];
                        right[1] = keypad[num][1];
                    }
                } else if (l < r) {
                    answer += 'L';
                    left[0] = keypad[num][0];
                    left[1] = keypad[num][1];
                } else if (r < l) {
                    answer += 'R';
                    right[0] = keypad[num][0];
                    right[1] = keypad[num][1];
                }
            }
        }
        
        return answer;
    }
}