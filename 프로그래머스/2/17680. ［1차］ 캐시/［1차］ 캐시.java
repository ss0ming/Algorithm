import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (list.isEmpty()) {
                list.add(city);
                answer += 5;
            } else if (list.contains(city)) {
                int idx = list.indexOf(city);
                list.remove(idx);
                list.add(city);
                answer += 1;
            } else if (!list.contains(city) && list.size() < cacheSize) {
                list.add(city);
                answer += 5;
            } else if (!list.contains(city) && list.size() == cacheSize) {
                list.remove(0);
                list.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}