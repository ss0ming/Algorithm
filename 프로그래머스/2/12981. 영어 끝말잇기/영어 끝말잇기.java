import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> checkWord = new ArrayList<>();
        checkWord.add(words[0]);
        
        for (int i=1; i<words.length; i++) {
            String beforeWord = words[i-1];
            String curWord = words[i];
            
            if (beforeWord.charAt(beforeWord.length()-1) != curWord.charAt(0)) {
                answer[0] = (i+1) % n == 0 ? n : (i+1) % n;
                answer[1] = (i+1) % n == 0 ? (i+1) / n: (i+1) / n + 1;
                break;
            } else if (checkWord.contains(curWord)) {
                answer[0] = (i+1) % n == 0 ? n : (i+1) % n;
                answer[1] = (i+1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                break;
            }
            
            checkWord.add(curWord);
        }

        return answer;
    }
}