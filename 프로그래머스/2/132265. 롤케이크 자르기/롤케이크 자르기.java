import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] leftSum = getLeftSum(topping);
        int[] rightSum = getRightSum(topping);
        
        for (int i=0; i<topping.length-1; i++) {
            if (leftSum[i] == rightSum[i+1]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static int[] getLeftSum(int[] topping) {
        Set<Integer> list = new HashSet<>();
        list.add(topping[0]);
        int[] sum = new int[topping.length];
        sum[0] = 1;
        
        for (int i=1; i<topping.length; i++) {
            if (list.contains(topping[i])) {
                sum[i] = sum[i-1];
            } else {
                sum[i] = sum[i-1] + 1;
                list.add(topping[i]);
            }
        }
        
        return sum;
    }
    
    private static int[] getRightSum(int[] topping) {
        Set<Integer> list = new HashSet<>();
        list.add(topping[topping.length-1]);
        int[] sum = new int[topping.length];
        sum[topping.length-1] = 1;
        
        for (int i=topping.length-2; i>=0; i--) {
            if (list.contains(topping[i])) {
                sum[i] = sum[i+1];
            } else {
                sum[i] = sum[i+1] + 1;
                list.add(topping[i]);
            }
        }
        
        return sum;
    }
}