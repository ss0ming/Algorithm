import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, (s1, s2) -> {
            String[] s1Name = splitFileName(s1);
            String[] s2Name = splitFileName(s2);
            
            int headCompare = s1Name[0].compareToIgnoreCase(s2Name[0]);
            if (headCompare != 0) {
                return headCompare;
            }
            
            int s1Num = Integer.parseInt(s1Name[1]);
            int s2Num = Integer.parseInt(s2Name[1]);
            
            return Integer.compare(s1Num, s2Num);
        });
        
        
        return files;
    }
    
    private static String[] splitFileName(String s) {
        String head = s.split("\\d")[0];
        String tail = s.substring(head.length()).split("\\D+")[0];
        
        return new String[]{head, tail};
    }
}