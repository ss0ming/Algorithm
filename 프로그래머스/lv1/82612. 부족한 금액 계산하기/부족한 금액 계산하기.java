class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long expectedMoney = 0;
        
        for (long i=1; i<=count; i++) {
            expectedMoney += (price*i);
        }
        
        answer = expectedMoney-money;
        
        if (answer < 0) {
            answer = 0;
        }

        return answer;
    }
}