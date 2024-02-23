import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<operations.length; i++) {
            String[] splitOp = operations[i].split(" ");
            
            if (splitOp[0].equals("I")) {
                list.add(Integer.parseInt(splitOp[1]));
            }
            
            if (list.isEmpty()) continue;
            
            if (splitOp[0].equals("D") && splitOp[1].equals("1")) {
                list.remove(list.indexOf(Collections.max(list)));
            } else if (splitOp[0].equals("D") && splitOp[1].equals("-1")) {
                list.remove(list.indexOf(Collections.min(list)));
            }
        }
        
        if (!list.isEmpty()) {
            answer[0] = Collections.max(list);
            answer[1] = Collections.min(list);
        }
        
        return answer;
    }
}