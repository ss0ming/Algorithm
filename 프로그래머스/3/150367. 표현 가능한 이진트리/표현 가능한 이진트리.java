class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            String nb = Long.toBinaryString(numbers[i]);
            int len = nb.length();
            int n = 1;
            while (true) {
                if (Math.pow(2, n)-1 >= len) {
                    break;
                }
                n++;
            }
            
            for (int z=0; z<Math.pow(2, n)-1-len; z++) {
                nb = "0" + nb;
            }
            
            boolean res = check(nb);
            if (res) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }        

        return answer;
    }
    
    private boolean check(String n) {
        if (n.length() == 0) return true;
        int mid = n.length() / 2;
        char root = n.charAt(mid);
        
        String left = n.substring(0, mid);
        String right = n.substring(mid+1);
        
        if (root == '0') {
            return isZero(left) && isZero(right);
        }
        
        return check(left) && check(right);
    }
    
    private boolean isZero(String n) {
        if (n.length() == 0) return true;
        int mid = n.length() / 2;
        char root = n.charAt(mid);
        
        String left = n.substring(0, mid);
        String right = n.substring(mid+1);
        
        if (root == '1') {
            return false;
        }
        
        return isZero(left) && isZero(right);
    }
}