import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int max = Math.max(arrayA[0], arrayB[0]);

        for (int i=max; i>1; i--) {
            if (isDivideAll(arrayA, i)) {
                if (isNotDivideAll(arrayB, i)) return i;
            }
            
            else if (isDivideAll(arrayB, i)) {
                if (isNotDivideAll(arrayA, i)) return i;
            } 
        }
        
        return 0;
    }
    
    private static boolean isDivideAll(int[] arr, int n) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % n != 0) return false;
        }
        return true;
    }
    
    private static boolean isNotDivideAll(int[] arr, int n) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % n == 0) return false;
        }
        return true;
    }
    
}