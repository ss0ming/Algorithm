import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) return cities.length * 5;
        
        List<String> list = new ArrayList<>();
        
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (list.contains(city)) {
                answer += 1;
                list.remove(list.indexOf(city));
                list.add(city);
            } else {
                answer += 5;
                if (list.size() < cacheSize) {
                    list.add(city);
                } else {
                    list.remove(0);
                    list.add(city);
                }
            }
        }
        
        return answer;
    }
}