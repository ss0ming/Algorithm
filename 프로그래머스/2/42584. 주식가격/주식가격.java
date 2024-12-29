import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> priceQueue = new LinkedList<>();

        for (int price : prices) {
            priceQueue.add(price);
        }

        int number = 0;
        while (priceQueue.peek() != null) {
            int value = priceQueue.poll();

            answer[number] = 0;

            for (Integer integer : priceQueue) {
                answer[number]++;
                if (value > integer) {
                    break;
                }
            }

            number++;
        }

        return answer;
    }
}