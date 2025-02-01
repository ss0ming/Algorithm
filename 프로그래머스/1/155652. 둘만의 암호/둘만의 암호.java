class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int stop = 0;

            while (stop < index){
                ch = (char) ((ch - 97 + 1) % 26 + 97);
                if (!skip.contains(String.valueOf(ch))){
                    stop++;
                }
            }
            answer += ch;

        }

        return answer;
    }
}