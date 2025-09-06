import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;
        int i = 0;
        List<Integer> res = new ArrayList<>();
        
        // S 제곱, D 2제곱, T 3제곱
        // * -> 해당 점수와 바로 전 점수 각각 2배! 첫번째 점수는 해당 점수만!
        // * 중첩 -> 점수 4배
        // # -> 해당 점수 마이너스
        // * 와 # 중첩 -> 점수 -2배
        while (i < dartResult.length()) {
            // 숫자부터 파싱
            int d = 0;
            if (dartResult.charAt(i+1) >= '0' && dartResult.charAt(i+1) <= '9') {
                d = Integer.parseInt(dartResult.substring(i, i+2));
                i += 2;
            } else {
                d = Integer.parseInt(dartResult.substring(i, i+1));
                i += 1;
            }
            
            // 몇 제곱인지
            char c = dartResult.charAt(i);
            if (c == 'D') {
                d = (int) Math.pow(d, 2);
            } else if (c == 'T') {
                d = (int) Math.pow(d, 3);
            }
            i++;
            
            // 옵션 확인
            if (dartResult.length() <= i) {
                res.add(d);
                break;
            }
            c = dartResult.charAt(i);
            if (c == '*') {
                d *= 2;
                if (idx != 0) {
                    res.set(idx-1, res.get(idx-1) * 2);
                }
                i++;
            } else if (c == '#') {
                d *= (-1);
                i++;
            }
            
            res.add(d);
            idx++;
        }
        
        for (int r=0; r<res.size(); r++) {
            answer += res.get(r);
        }
        return answer;
    }
}