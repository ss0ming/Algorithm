class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i=1; i<arr.length; i++) {
            if (answer > arr[i]) {
                answer = answer * arr[i] / gcd(answer, arr[i]);
            } else {
                answer = answer * arr[i] / gcd(arr[i], answer);
            }
        }
        
        return answer;
    }
    
    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}