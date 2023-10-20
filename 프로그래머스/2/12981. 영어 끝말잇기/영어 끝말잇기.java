import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        ArrayList<String> list = new ArrayList<String>();
        
        for (int i=0; i<words.length; i++) {
            if (list.isEmpty()) {
                list.add(words[i]);
                continue;
            }
            String beforeWord = list.get(list.size()-1);
            if (list.contains(words[i]) || beforeWord.charAt(beforeWord.length()-1) != words[i].charAt(0) || words[i].length() == 1) {
                int playerN = i % n+1;
                if (playerN == 0) playerN = n;
                
                answer[0] = playerN;
                answer[1] = i / n + 1;
                break;
            }
            list.add(words[i]);
        }

        return answer;
    }
}