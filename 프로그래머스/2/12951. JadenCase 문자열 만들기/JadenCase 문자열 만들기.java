class Solution {
    public String solution(String s) {
        String answer = "";
        int flag = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (flag == 0 && (c > 96 && c < 123)) {
                answer += (char)(c-32);
                flag = 1;
            } else if (flag == 1 && (c > 64 && c < 91)) {
                answer += (char)(c+32);
            } else if (c == ' ') {
                answer += c;
                flag = 0;
            } else {
                answer += c;
                flag = 1;
            }
        }
        
        //System.out.println(answer);
        
        return answer;
    }
}