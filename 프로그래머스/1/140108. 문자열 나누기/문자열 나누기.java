class Solution {
    public int solution(String s) {
        int answer = 1;
        
        char c = s.charAt(0);
        int cnt = 1;
        
        for (int i=1; i<s.length(); i++) {
            if (cnt == 0) {
                answer++;
                c = s.charAt(i);
            }

            if (c == s.charAt(i)) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        return answer;
    }
}