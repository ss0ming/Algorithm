class Solution {
    public int solution(int n) {
        int answer = 1;
        int tmp = 0;
        
        for (int i=1; i<=n/2; i++) {
            tmp += i;
            int idx = i + 1;
            while (true) {
                tmp += (idx++);
                if (tmp == n) {
                    answer++;
                    tmp = 0;
                    break;
                }
                if (tmp > n) {
                    tmp = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}