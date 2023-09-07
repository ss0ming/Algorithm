import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        ArrayList<Long> arr = new ArrayList<Long>();
        
        while (n != 0) {
            arr.add(n % 10);
            n /= 10;
        }
        
        Collections.sort(arr);
        
        long ten = 10;
        answer = arr.get(0);
        
        for (int i=1; i<arr.size(); i++) {
            System.out.println(arr.indexOf(i));
            answer += (arr.get(i) * ten);
            System.out.println(answer);
            ten *= 10;
        }
        
        return answer;
    }
}