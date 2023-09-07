class Solution {
    public long solution(long n) {
        long answer = -1;
        long i = 1;
        
        while (n >= i*i) {
            if (i*i == n) {
                answer = (i+1) * (i+1);
                break;
            }
            i++;
        }
        
        return answer;
    }
}