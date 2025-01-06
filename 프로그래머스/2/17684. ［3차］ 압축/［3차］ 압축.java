import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int idx = 0;
        String tmp = "";
        
        resetDictionary(dictionary);
        
        while (idx < msg.length()) {
            // 다음 글자 붙이기
            tmp += msg.charAt(idx++);
            
            // 만약 다음 글자를 붙인 tmp가 사전에 없으면
            // tmp를 사전에 추가하고 붙이기 전에 글자의 사전 번호를 answer에 추가
            if (!dictionary.containsKey(tmp)) {
                dictionary.put(tmp, dictionary.size()+1);
                answer.add(dictionary.get(tmp.substring(0, tmp.length()-1)));
                tmp = Character.toString(msg.charAt(idx-1));
            }
            
        }
        answer.add(dictionary.get(tmp));
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static void resetDictionary(Map<String, Integer> dictionary) {
        for (int i=0; i<26; i++) {
            dictionary.put(Character.toString((char) ('A' + i)), i+1);
        }
    }
}