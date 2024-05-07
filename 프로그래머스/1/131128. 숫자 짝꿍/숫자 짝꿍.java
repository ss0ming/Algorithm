import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] y = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for (String s : X.split("")) {
            x[Integer.parseInt(s)]++;
        }
        
        for (String s : Y.split("")) {
            y[Integer.parseInt(s)]++;
        }
        
        for (int i=9; i>=0; i--) {
            for (int j=0; j<Math.min(x[i], y[i]); j++) {
                answer.append(i);
            }
        }
        
        if (answer.toString().equals("")) {
            return "-1";
         } else if (answer.toString().startsWith("0")) {
            return "0";
        }
        
        return answer.toString();
    }
}