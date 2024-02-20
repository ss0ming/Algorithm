import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.substring(2, s.length()-2);
        
        String[] strs = s.split("\\},\\{");
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String o1, String o2){
                
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        List<Integer> list = new LinkedList<>();
        
        for(String str : strs) {
            String[] nums = str.split(",");
            for (String n : nums) {
                int num = Integer.parseInt(n);
                if (list.contains(num)) continue;
                list.add(num);
            }
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}