class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        
        for (int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            
            if (tmp == ' ') {
                idx = 0;
                answer += ' ';
                continue;
            }
            
            if (idx%2 == 0) {
                tmp = Character.toUpperCase(tmp);
            } else {
                tmp = Character.toLowerCase(tmp);
            }
            idx++;
            answer += tmp;
        }
        return answer;
    }
}