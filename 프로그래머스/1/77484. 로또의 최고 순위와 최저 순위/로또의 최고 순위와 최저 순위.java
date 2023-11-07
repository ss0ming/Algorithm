import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        int zeroCnt = 0;
        int rightCnt = 0;
        
        for (int num : lottos) {
            list.add(num);
            if (num == 0) zeroCnt++;
        }
        
        for (int num : win_nums) {
            if (list.contains(num)) rightCnt++;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);
        
        answer[0] = map.get(rightCnt+zeroCnt);
        answer[1] = map.get(rightCnt);
        
        return answer;
    }
}