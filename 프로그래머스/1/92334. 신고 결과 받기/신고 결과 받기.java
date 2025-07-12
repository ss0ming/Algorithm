import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idx = new HashMap<>();
        List<Set<String>> result = new ArrayList<>();
        
        for (int i=0; i<id_list.length; i++) {
            idx.put(id_list[i], i);
            result.add(new HashSet<>());
            
        }
        
        for (int i=0; i<report.length; i++) {
            String[] splitId = report[i].split(" ");
            
            result.get(idx.get(splitId[1])).add(splitId[0]);
        }
        
        for (int i=0; i<result.size(); i++) {
            if (result.get(i).size() < k) continue;
            for (String id : result.get(i)) {
                answer[idx.get(id)]++;
            }
        }
        
        return answer;
    }
}