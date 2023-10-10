import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] successStage = new int[N+2];
        int usersN = stages.length;
        HashMap<Integer, Double> map = new HashMap<>();
        
        for (int i=0; i<stages.length; i++) {
            successStage[stages[i]]++;
        }
        
        // System.out.println(Arrays.toString(successStage));
        
        for (int i=1; i<N+1; i++) {
            double failureRate = 0;
            if (successStage[i] != 0) {
                failureRate = (double)successStage[i]/usersN;
            }
            map.put(i, failureRate);
            usersN -= successStage[i];
            // System.out.println(usersN);
        }

        // System.out.println("개수: " + map.size());
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        int idx = 0;
        
        for (Integer i : list) {
            answer[idx++] = i;
        }
        
        
        return answer;
    }
}