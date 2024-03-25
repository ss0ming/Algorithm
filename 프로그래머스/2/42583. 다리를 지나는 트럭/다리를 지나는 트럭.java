import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
 
        Queue<Integer> bridge = new LinkedList<>();
        int passing_truck = 0;
        
        int w = 0;
        int answer = 0;
        
        for (int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    w += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    w -= bridge.poll();
                } else {
                    if (w + truck <= weight) {
                        bridge.add(truck);
                        w += truck;
                        answer++;
                        break;
                    } else {
                        bridge.add(0);
                        answer++;
                    }
                    
                }
            }
        }
        
        return answer + bridge_length;
    }
    
}