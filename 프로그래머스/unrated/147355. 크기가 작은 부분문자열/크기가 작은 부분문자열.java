class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i=0; i<t.length()-p.length()+1; i++) {
            String n = t.substring(i, i + p.length());
            //System.out.println(n);
            if (Long.parseLong(n) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}