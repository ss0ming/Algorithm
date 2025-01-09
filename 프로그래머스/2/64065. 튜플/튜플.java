import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String[]> tuples = new ArrayList<>();
        
        s = s.substring(2, s.length()-2);
        String[] splitS = s.split("\\},\\{");
        
        for (int i=0; i<splitS.length; i++) {
            tuples.add(splitS[i].split(","));
        }
        
        tuples.sort(Comparator.comparingInt(arr -> arr.length));
        int[] answer = new int[tuples.size()];
        Set<String> set = new HashSet<>();
        
        int idx = 0;
        for (int t=0; t<tuples.size(); t++) {
            String[] tuple = tuples.get(t);
            for (int i=0; i<tuple.length; i++) {
                if (!set.contains(tuple[i])) {
                    answer[idx++] = Integer.parseInt(tuple[i]);
                    set.add(tuple[i]);
                }
            }
        }
        
        return answer;
    }
}