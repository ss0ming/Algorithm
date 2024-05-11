class Solution {
    public int solution(int n) {
        int answer = 0;
        
        answer = n / 7;
        System.out.println(answer);
        
        if (n % 7 != 0) answer += 1;
        
        return answer;
    }
}