class Solution {
    public int solution(int n) {
        int answer = n+1;
        
        String s = Integer.toString(n, 2);
        
        int cntN = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                cntN++;
            }
        }
        
        int cnt = 0;
        
        while (true) {
            s = Integer.toString(answer, 2);
        
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    cnt++;
                }
            }
            if (cnt == cntN) break;
            cnt = 0;
            answer += 1;
        }
        
        return answer;
    }
}