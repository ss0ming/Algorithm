import java.util.*;

class Food {
    int time, index;
    Food(int index, int time) {
        this.index = index;
        this.time = time;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        Food[] foods = new Food[n];
        for (int i = 0; i < n; i++) foods[i] = new Food(i + 1, food_times[i]);
        
        Arrays.sort(foods, Comparator.comparingInt(f -> f.time));
        
        long prev = 0;  
        int i;
        for (i = 0; i < n; i++) {
            long diff = foods[i].time - prev;
            if (diff != 0) {
                long spend = diff * (long)(n - i);
                if (spend <= k) {
                    k -= spend;
                    prev = foods[i].time;
                } else {
                    break;
                }
            }
        }
        
        List<Food> remain = new ArrayList<>();
        for (int j = i; j < n; j++) remain.add(foods[j]);
        if (remain.isEmpty()) return -1;
        
        remain.sort(Comparator.comparingInt(f -> f.index));
        return remain.get((int)(k % remain.size())).index;
    }
}
