class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int pN = 0;
        int yN = 0;
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                pN += 1;
            }
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                yN += 1;
            }
        }

        if (pN == yN) {
            answer = true;
        }
        return answer;
    }
}