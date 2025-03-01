class Solution {
    public int[] solution(int[] sequence, int k) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end   = 0;
        long cur  = 0;
        int answer_st = -1;
        int answer_en = -1; 
        for(int i = 0; i < sequence.length; i++){
            end++;
            cur += sequence[i];
            if(cur < k) continue;
            if(cur == k){
                if(min > end - start + 1){
                    min = end - start + 1;
                    answer_st = start;
                    answer_en = end - 1;
                }
            }
            else{
                while(cur > k){
                    cur -= sequence[start++];
                }
                if(cur == k){
                    if(min > end - start + 1){
                        min = end - start + 1;
                        answer_st = start;
                        answer_en = end - 1;
                    }
                } 
            }
        }
        return new int []{answer_st, answer_en};

    }
}