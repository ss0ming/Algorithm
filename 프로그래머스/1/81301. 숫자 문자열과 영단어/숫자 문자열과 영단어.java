class Solution {
    public int solution(String s) {
        String[] intToEng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i=0; i<intToEng.length; i++) {
            String intToString = Integer.toString(i);
            s = s.replaceAll(intToEng[i], intToString);
        }
        
        return Integer.parseInt(s);
    }
}