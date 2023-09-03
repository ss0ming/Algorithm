class Solution {
    public int solution(int n) {
        
        int answer = findRemainderZero(n-1);
        return answer;
    }
    
    public static int findRemainderZero(int n) {
        for (int i=2; i<n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }
}