import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] days = new int[len];
        
        for (int i=0; i<len; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days[i] += 1;
            }
        }
        
        int tmp = days[0];
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<len; i++) {
            if (tmp >= days[i]) {
                cnt++;
            } else {
                list.add(cnt);
                tmp = days[i];
                cnt = 1;
            }
            
            if (i == len-1) {
                list.add(cnt);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}