import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> map = new HashMap<>();        
        for (int i=1; i<=N+1; i++) {
            map.put(i, 0);
        }
        
        for (int i=0; i<stages.length; i++) {
            int stg = stages[i];
            map.put(stg, map.get(stg) + 1);
        }
        
        int user = stages.length;
        double[][] res = new double[N][2];
        for (int i=1; i<=N; i++) {
            res[i-1][0] = i;
            if (user == 0) res[i-1][1] = 0;
            else res[i-1][1] = (double) map.get(i)/user;
            user -= map.get(i);
        }
        
        Arrays.sort(res, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return (int) (o1[0] - o2[0]);
            }
            if (o2[1] - o1[1] > 0) {
                return 1;
            }
            return -1;
        });
        
        for (int i=0; i<N; i++) {
            answer[i] = (int) res[i][0];
        }
        
        return answer;
    }
}