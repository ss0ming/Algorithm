class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if (m > n) {
            if (m%n == 0) {
                answer[0] = n;
                answer[1] = m; 
            } else {
                for (int i=1; i<=n; i++) {
                    if (m%i == 0 && n%i == 0) {
                        answer[0] = i;
                    }
                }
            }  
        } else if (n > m) {
            if (n%m == 0) {
                answer[0] = m;
                answer[1] = n;
            } else {
                for (int i=1; i<=m; i++) {
                    if (m%i == 0 && n%i == 0) {
                        answer[0] = i;
                    }
                }
            } 
        }
        answer[1] = n * m / answer[0];
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
}