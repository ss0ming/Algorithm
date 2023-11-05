import java.util.*;

class Solution {
    
    public static int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
       
        Map<String, Integer> wantList = new HashMap<>();
        
        for (int i=0; i<number.length; i++) {
            wantList.put(want[i], number[i]);
        }

        for (int i=0; i<discount.length-10+1; i++) {
            Map<String, Integer> discountList = new HashMap<>();
            for (int j=i; j<i+10; j++) {
                discountList.put(discount[j], discountList.getOrDefault(discount[j], 0) + 1);
            }
            check(wantList, discountList);
        }
        
        return answer;
    }
    
    public void check(Map<String, Integer> want, Map<String, Integer> discount) {
        boolean bool = true;
        for (String s : want.keySet()) {
            if (!discount.containsKey(s) || want.get(s) > discount.get(s)) bool = false;
        }
        if (bool) answer++;
    }
}