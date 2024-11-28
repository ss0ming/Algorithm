import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=commands[i][0]-1; j<commands[i][1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer.add(list.get(commands[i][2]-1));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}