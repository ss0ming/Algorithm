class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            String n1 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String n2 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
            
            String ans = "";
            
            for (int j=0; j<n; j++) {
                if (n1.charAt(j) == '0' && n2.charAt(j) == '0') {
                    ans += " ";
                } else {
                    ans += "#";
                }
            }
            answer[i] = ans;
        }
        
        return answer;
    }
}