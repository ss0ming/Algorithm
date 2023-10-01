import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(name));
        
        for (int i=0; i<photo.length; i++) {
            int sum = 0;
            for (int j=0; j<photo[i].length; j++) {
                if (list.contains(photo[i][j])) {
                    answer[i] += yearning[list.indexOf(photo[i][j])];
                }
            }
        }
        
        return answer;
    }
}