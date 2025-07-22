class Solution {
    public long solution(int price, int money, int count) {
        long answer = (long)price * (count + 1) * count / 2;
        answer = money - answer;
        
        if (answer > 0) {
            return 0;
        }

        return -answer;
    }
}