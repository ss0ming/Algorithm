import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        int size = set.size();
        Map<String, Integer> map = new HashMap<>();
        int len = gems.length+1;
        int l = 0;
        
        for (int r=0; r<gems.length; r++) {
            map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            
            while(map.get(gems[l]) > 1){
                map.put(gems[l], map.get(gems[l])-1);
                l++;
            }
            
            if(map.size() == size && len > r-l){
                len = r-l;
                answer[0] = l+1;
                answer[1] = r+1;
            }
        }
        
        return answer;
    }
}