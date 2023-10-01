class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] months = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int sum = 0;
        
        for (int i=1; i<a; i++) {
            sum += days[i];
        }
        
        sum += b;
        
        answer = months[sum % 7];
        
        return answer;
    }
}