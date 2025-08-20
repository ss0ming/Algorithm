import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // Map으로 설정 
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();
        
        for (int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
        
        for (int i=0; i<seller.length; i++) {
            String slr = seller[i];
            int amt = amount[i] * 100;
            
            while (true) {
                money.put(slr, money.get(slr) + amt - (int) (amt * 0.1));
                if (parent.get(slr).equals("-")) {
                    break;
                }
                slr = parent.get(slr);
                amt = (int) (amt * 0.1);
                if (amt < 1) break;
            }
        }
        
        for (int i=0; i<enroll.length; i++) {
            answer[i] = money.get(enroll[i]);
        }
        
        return answer;
    }
}