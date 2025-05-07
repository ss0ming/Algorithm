import java.util.*;

class Solution {
    int len;
    public long solution(int[] weights) {
        long answer = 0;
        len = weights.length;
        Arrays.sort(weights);
        int prev  =0 ;
        for(int i =0 ;i <len-1;i++){
            if(i > 0 && weights[i] == weights[i-1]){
                prev--;
                answer+=prev;
                continue;
            }
            int j = findRignt(weights,weights[i], i+1);
            prev = 0;
            for(; j > i ;j --){
                if(weights[i] == weights[j] || weights[i] * 2== weights[j] 
                   || weights[i] * 3 == weights[j] * 2 || weights[i] * 4 == weights[j] * 3){
                    prev++;
                }
            }
            answer+=prev;
        }
        return answer;
    }
    public int findRignt(int[] w, int num, int i){
        int left = i;
        int right = len-1;
        while(left < right){
            int mid = left +(right-left)/2;
            if(w[mid] > num*2)return mid;
            else left = mid+1;
        }
        return left;
    }
}