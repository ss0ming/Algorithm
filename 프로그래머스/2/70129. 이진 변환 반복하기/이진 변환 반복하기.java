class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zero = 0;
        int one = 0;
        String str = s;
           
        while (true) {
            one = 0;
            zero = 0;
            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if (c == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
            str = Integer.toString(one, 2);
            answer[0]++;
            answer[1] += zero;
            if (str.equals("1")) break;
        }
        
        return answer;
    }
}