class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            int cnt = prime(i);
            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }
        
        return answer;
    }
    public static int prime(int n) {
        int res = 0;
        
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n == i*i) res += 1;
            else if (n%i == 0) res += 2;
        }
        return res;
    }
}