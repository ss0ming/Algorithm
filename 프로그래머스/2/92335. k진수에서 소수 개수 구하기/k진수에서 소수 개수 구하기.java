class Solution {
    
    static int answer = 0;
    
    public int solution(int n, int k) {
        String nk = Integer.toString(n, k);
        String tmp = "";
        
        for (int i=0; i<nk.length(); i++) {
            Character c = nk.charAt(i);
            if (c == '0') {
                check(tmp);
                tmp = "";
            } else {
                tmp += c;
            }
        }
        check(tmp);
        
        return answer;
    }
    
    private static void check(String s) {
        if (s.equals("") || s.equals("1")) return;
        long n = Long.parseLong(s);
        
        if (n <= 3) {
            answer++;
            return;
        } 
        
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return;
        }
        
        answer++;
    }
}