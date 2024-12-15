import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) {
            if (map.get(i) != null) {
                 map.put(i, map.get(i)+1);
            } else {
                 map.put(i, 1);
            }
        }

        List<Integer> arr = new ArrayList<>();
        for(Integer value : map.values()) {
            arr.add(value);
        }

        Collections.sort(arr, Collections.reverseOrder());
        for(Integer i : arr){
            answer++;
            k -= i;
            if ((k) <= 0) {
                break;
            }
        }

        return answer;
    }
}