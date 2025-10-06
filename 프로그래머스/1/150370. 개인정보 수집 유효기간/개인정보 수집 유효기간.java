import java.util.*;

class Solution {
    
    static Map<String, Integer> termMap = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayNum = strToInt(today);

        for (int i=0; i<terms.length; i++) {
            String[] split = terms[i].split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int p = addTerms(split[0], termMap.get(split[1]));
            
            if (p <= todayNum) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static int addTerms(String str, int n) {
        String[] split = str.split("\\.");
        
        int y = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);

        if (n < 12) {
            m += n;
            if (m > 12) {
                y += 1;
                m -= 12;
            }
        } else if (n == 12) {
            y += 1;
        } else {
            y += n/12;
            m += n%12;
            if (m > 12) {
                y += 1;
                m -= 12;
            }
        }
        
        String result = String.format("%02d%02d%02d", y, m, d);
        return Integer.parseInt(result);
    }
    
    private static int strToInt(String str) {
        str = str.replace(".", "");
        return Integer.parseInt(str);
    }
}