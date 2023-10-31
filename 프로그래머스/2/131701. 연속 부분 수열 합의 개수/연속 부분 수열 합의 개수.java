import java.util.*;

class Solution {
    public static List<Integer> list;
    
    public int solution(int[] elements) {
        int answer = 0;
        
        int[] memo = new int[elements.length];
         list = new LinkedList<>();
        
        for (int i=0; i<elements.length; i++) {
            memo = add(elements, memo);
        }
        
        Set<Integer> set = new HashSet<>(list);
        answer = set.size();
        
        return answer;
    }
    
    public int[] add(int[] elements, int[] memo) {
        int[] tmp = new int[elements.length];
        
        for (int i=0; i<memo.length; i++) {
            if (i == 0) {
                tmp[i] = elements[i] + memo[memo.length - 1]; 
            } else {
                tmp[i] = elements[i] + memo[i-1];
            }
            list.add(tmp[i]);
        }
        
        return tmp;
    }
}