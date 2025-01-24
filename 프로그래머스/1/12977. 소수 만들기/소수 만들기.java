import java.util.*;

class Solution {
    public int solution(int[] nums) {
        List<Integer> primeNumbList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        boolean primeYn = false;
        int answer = 0;

        for (int a=2; a<=50000; a++) {
            primeYn = true;
            for(int i = 2; i <= Math.sqrt(a); i++) {
                if(a % i == 0) {
                    primeYn = false;
                    break;
                }
            }
            if (primeYn) {
                primeNumbList.add(a);
            }
        }

        for (int i=0; i<nums.length; i++) {
            for (int k=i+1; k<nums.length; k++) {
                for (int l=k+1; l<nums.length; l++) {
                    sumList.add(nums[i] + nums[k] + nums[l]);
                }
            }
        }

        for (int i : sumList) {
            if (primeNumbList.contains(i)) {
                answer++;
            }
        }
        
        return answer;
    }
}