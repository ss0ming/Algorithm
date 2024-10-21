class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] strs1 = new String[n];
        String[] strs2 = new String[n];
        
        for (int i=0; i<n; i++) {
            strs1[i] = fillZero(Integer.toString(arr1[i], 2), n);
            strs2[i] = fillZero(Integer.toString(arr2[i], 2), n);
        }
        
        for (int i=0; i<n; i++) {
            String s = "";
            for (int j=0; j<n; j++) {
                if (strs1[i].charAt(j) == '0' && strs2[i].charAt(j) == '0') {
                    s += " ";
                } else {
                    s += "#";
                }
            }
            answer[i] = s;
        }
        
        return answer;
    }
    
    public static String fillZero(String s, int n) {
        String res = "";
    
        for (int i=0; i<n-s.length(); i++) {
            res += "0";
        }
        
        res += s;
        
        return res;
    }
}