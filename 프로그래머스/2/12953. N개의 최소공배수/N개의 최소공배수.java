import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = leastCommonMultiple(Math.min(arr[0], arr[1]), Math.max(arr[0], arr[1]));
        
        for (int i=2; i<arr.length; i++) {
            answer = leastCommonMultiple(Math.min(answer, arr[i]), Math.max(answer, arr[i]));
        }
        
        return answer;
    }
    
    public static int leastCommonMultiple(int a, int b) {
        int res = a * b;
        int i = a;
        while (true) {
            if (a % i == 0 && b % i == 0) break;
            i--;
        }
        return res / i;
    }
}