class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n;
        int m = (l + r) / 2;
        
        while (l <= r) {
            
            
            if (check(citations, m) < m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = (l + r) / 2;
        }
        
        return m;
    }
    
    private static int check(int[] citations, int h) {
        int cnt = 0;
        
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= h) {
                cnt++;
            }
        }
        
        return cnt;
    }
}