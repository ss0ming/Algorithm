import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        init(map);
        
        for (int i=0; i<survey.length; i++) {
            int choice = choices[i]; 
            if (choice < 4) {
                map.replace(survey[i].charAt(0), map.get(survey[i].charAt(0)) - (choice-4));
            } else if (choice > 4) {
                map.replace(survey[i].charAt(1), map.get(survey[i].charAt(1)) + (choice-4));
            }
        }
        
        answer += selectType('R', 'T', map);
        answer += selectType('C', 'F', map);
        answer += selectType('J', 'M', map);
        answer += selectType('A', 'N', map);
        
        return answer;
    }
    
    public static void init(Map<Character, Integer> map) {
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
    }
    
    public static char selectType(char one, char two, Map<Character, Integer> map) {
        if (map.get(one) < map.get(two)) return two;
        return one;
    }
}