class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String s = "";
        int n = 0;
        int flag = 1;
        int beforeN = 0;
        
        for (int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c > 47 && c < 58) {
                if (flag == 1) {
                    answer += n;
                    beforeN = n;
                    s = "";
                }
                s += c;
                flag = 0;
            } else if (c == '*') {
                if (flag == 0) {
                    n = Integer.parseInt(s);
                    
                } 
                answer -= beforeN;
                answer += (beforeN*2);
                n *= 2;
                flag = 1;
            } else if (c == '#') {
                if (flag == 0) {
                    n = Integer.parseInt(s);
                } 
                n *= (-1);
                flag = 1;
            } else if (c == 'S') {
                if (flag == 0) {
                    n = Integer.parseInt(s);
                }
                flag = 1;
            } else if (c == 'D') {
                if (flag == 0) {
                    n = Integer.parseInt(s);
                } 
                n = (int)Math.pow(n, 2);
                flag = 1;
            } else if (c == 'T') {
                if (flag == 0) {
                    n = Integer.parseInt(s);
                } 
                n = (int)Math.pow(n, 3);
                flag = 1;
            }
            // System.out.println(n);
            // System.out.println("answer: " + answer);
        }
        
        answer += n;
        
        return answer;
    }
}