class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = s.length()/2;
        
        if (s.length() % 2 == 0) {
            answer += s.charAt(idx-1);
            answer += s.charAt(idx);
        } else {
            answer += s.charAt(idx);
        }
        
        return answer;
    }
}