import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String ns = " " + s;
        
        for (int i=1; i<ns.length(); i++) {
            if (ns.charAt(i-1) == ' ') {
                answer += Character.toUpperCase(ns.charAt(i));
            } else {
                answer += Character.toLowerCase(ns.charAt(i));
            }
        }
        
        return answer;
    }
}