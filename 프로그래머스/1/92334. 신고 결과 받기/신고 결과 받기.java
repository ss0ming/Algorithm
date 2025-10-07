import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            mail.put(id_list[i], 0);
        }
        
        for (int i=0; i<report.length; i++) {
            String[] split = report[i].split(" ");
            map.get(split[1]).add(split[0]);
        }

        for (int i=0; i<id_list.length; i++) {
            Set<String> tmp = map.get(id_list[i]);
            if (tmp.size() >= k) {
                for (String p : tmp) {
                    mail.put(p, mail.get(p) + 1);
                }
            }
        }
        
        for (int i=0; i<id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }
        
        return answer;
    }
}