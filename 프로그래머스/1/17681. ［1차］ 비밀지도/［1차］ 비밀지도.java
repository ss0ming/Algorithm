import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            String a = String.format("%0" + Long.toString(n) + "d", Long.parseLong(Long.toString(arr1[i], 2)));
            String b = String.format("%0" + Long.toString(n) + "d", Long.parseLong(Long.toString(arr2[i], 2)));
            
            String str = "";
            for (int j=0; j<n; j++) {
                if (a.charAt(j) == '0' && b.charAt(j) == '0') str += " ";
                else str += "#";
            }
            answer[i] = str;
        }
        
        return answer;
    }
}