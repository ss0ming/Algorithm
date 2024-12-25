class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right-left+1);
        int[] answer = new int[len];
        int idx = 0;
        
        for (long i=left; i<=right; i++) {
            int a = (int) (i / n + 1);
            int b = (int) (i % n + 1);
            
            if (a >= b) answer[idx] = a;
            else answer[idx] = b;
            idx++;
        }
        
        return answer;
    }
}