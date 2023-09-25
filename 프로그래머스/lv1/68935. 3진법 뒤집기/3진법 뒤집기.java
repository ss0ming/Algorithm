class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(s);
        
        String revN = sb.reverse().toString();
        
        answer = Integer.parseInt(revN, 3);
        
        return answer;
    }
}