import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        init(map);
        
        for (int i=0; i<survey.length; i++) {
            int choice = choices[i];
            if (choice == 4) {
                continue;
            } else if (choice < 4) {
                char type = survey[i].charAt(0);
                map.put(type, map.get(type) + Math.abs(choice - 4));
            } else {
                char type = survey[i].charAt(1);
                map.put(type, map.get(type) + choice - 4);
            }
        }
        
        if (map.get('R') >= map.get('T')) {
            answer += 'R';
        } else {
            answer += 'T';
        }
        
        if (map.get('C') >= map.get('F')) {
            answer += 'C';
        } else {
            answer += 'F';
        }
        
        if (map.get('J') >= map.get('M')) {
            answer += 'J';
        } else {
            answer += 'M';
        }
        
        if (map.get('A') >= map.get('N')) {
            answer += 'A';
        } else {
            answer += 'N';
        }
        
        return answer;
    }
    
    private void init(Map<Character, Integer> map) {
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
    }
}