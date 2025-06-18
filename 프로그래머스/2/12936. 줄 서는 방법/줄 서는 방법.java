import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        long fac = fac(n, 1);
        long deno = 1;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(i+1);
        }
        
        int[] answer = new int[n];
        int idx = 0;
        k=k-1;
        
        for (int i=n; i>0; i--) {
            deno *= i;
            long num = fac/deno;
            long mok = k/num;
            k = k%num;
            int cur = list.remove((int) mok);
            answer[idx++] = cur;
        }
        
        return answer;
    }
    
    public long fac(int n, long sum) {
        if (n > 1) {
            return fac(n-1, sum * n);
        } else {
            return sum;
        }
    }
}