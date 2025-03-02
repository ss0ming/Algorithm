import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = sequence[0];
        int left = 0;
        int right = 0;
        int len = sequence.length;
        List<int[]> list = new ArrayList<>();

        while(right < len && left < len) {
            if (sum == k) {
                list.add(new int[]{left, right});
            }
        
            if (sum <= k) {
                right++;
                if (right < len) {
                    sum += sequence[right];  
                }
            } else {
                if (left < len) {
                    sum -= sequence[left];
                }
                left++;
            }
        }
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int len1 = o1[1] - o1[0];
                int len2 = o2[1] - o2[0];
                return len1 - len2;
            }
        });
        
        return list.get(0);

    }
}