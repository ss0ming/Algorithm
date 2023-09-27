class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if ((c >= 97 && c<=122) && (c+n > 122)) {
                    answer += (char)(c + n - 26);
                } else if ((c >= 65 && c <= 90) && (c+n > 90)) {
                    answer += (char)(c + n - 26);
                }else {
                    answer += (char)(c + n);
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}