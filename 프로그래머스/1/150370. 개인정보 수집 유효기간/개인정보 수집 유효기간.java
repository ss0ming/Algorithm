import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[][] expired = new String[privacies.length][2];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            map.put(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
        }

        for (int i=0; i<privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            
            expired[i][0] = Integer.toString(i);
            expired[i][1] = calculate(map.get(tmp[1].charAt(0)), tmp[0]);

        }
        
        Arrays.sort(expired, new Comparator<>() {
           @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        
        today = today.replace(".", "");
        for (int i=0; i<expired.length; i++) {
            if (Integer.parseInt(today) <= Integer.parseInt(expired[i][1])) break; 
            answer.add(Integer.parseInt(expired[i][0])+1);
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private String calculate(int term, String date) {
        String[] splitDate = date.split("\\.");
        
        int y = Integer.parseInt(splitDate[0]);
        int m = Integer.parseInt(splitDate[1]);
        int d = Integer.parseInt(splitDate[2]);
        
        m += term;
        if (m > 12) {
            y += (m / 12);
            m = m - (12 * (m / 12));
        }
        
        d -= 1;
        if (d == 0) {
            d = 28;
            m -= 1;
        }
        if (m == 0) {
            m = 12;
            y -= 1;
        }
        
        String res = Integer.toString(y);
        res += dateToString(m);
        res += dateToString(d);
        
        return res;
    }
    
    private String dateToString(int d) {
        String res = Integer.toString(d);
        if (res.length() == 1) {
            return "0" + res;
        }
        return res;
    }
}