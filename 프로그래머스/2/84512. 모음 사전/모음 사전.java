import java.util.*;

class Solution {
    
    static Character[] chars = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        
        makeDic("", list);
        
        return list.indexOf(word);
    }
    
    private static void makeDic(String word, List<String> list) {
        list.add(word);
        if (word.length() == 5) return;
        
        for (char c : chars) {
            makeDic(word+c, list);
        }
    }
}