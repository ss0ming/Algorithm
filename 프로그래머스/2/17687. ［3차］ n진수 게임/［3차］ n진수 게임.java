class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String strs = "";
        int k = 0;
        
        while (strs.length() <= t * m) {
            strs += Integer.toString(k, n);
            k++;
        }
        
        p -= 1;
        
        while (t != answer.length()) {
            answer += strs.charAt(p);
            p += m;
        }
        
        return answer.toUpperCase();
    }
}