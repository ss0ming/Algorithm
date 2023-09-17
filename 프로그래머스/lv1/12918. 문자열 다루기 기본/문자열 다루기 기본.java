class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 48 || arr[i] > 57) {
                answer = false;
                break;
            }
        }
        
        if (s.length() != 4 && s.length() != 6) {
            answer = false;
        }
        
//         char a = 48;
//         char b = 57;
        
//         System.out.println(a);
//         System.out.println(b);
        return answer;
    }
}