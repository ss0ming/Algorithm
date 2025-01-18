class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] numbers = new boolean[n+1];
        for(int i = 2 ; i <= n ; i++){
            if(!numbers[i]){
                answer++;
                for(int j = i*2 ; j <= n ; j = j+i){
                    numbers[j] = true;
                }
            }
        }
        
        return answer;
    }
}