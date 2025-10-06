import java.util.*;

class Solution {
    
    static int[] answer = new int[2];
    static int[] emoPrice;
    static int[][] user;
    
    public int[] solution(int[][] users, int[] emoticons) {
        emoPrice = Arrays.copyOf(emoticons, emoticons.length);
        user = Arrays.copyOf(users, users.length);
        int[] tmp = new int[emoticons.length];
        
        back(emoticons.length, tmp, 0);
        
        return answer;
    }
    
    private static void back(int n, int[] tmp, int depth) {
        if (depth == n) {
            check(tmp);
            return;
        }
        
        for (int i=0; i<4; i++) {
            tmp[depth] = (i+1) * 10;
            back(n, tmp, depth+1);
        }
    }
    
    private static void check(int[] arr) {
        
        int[] price = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            price[i] = emoPrice[i] - (arr[i] * emoPrice[i])/100;
        }
        
        
        // 이모티콘 사는 가격
        int[] buy = new int[user.length];
        for (int i=0; i<user.length; i++) {
            for (int j=0; j<price.length; j++) {
                if (arr[j] >= user[i][0]) {
                    buy[i] += price[j];
                }
            }
        }
        
        // 임티플 가입자 수랑 판매액 계산
        int sub = 0;
        int amount = 0;
        for (int i=0; i<user.length; i++) {
            if (user[i][1] <= buy[i]) {
                sub++;
            } else {
                amount += buy[i];
            }
        }
        
        // 정답 비교
        if (sub > answer[0]) {
            answer[0] = sub;
            answer[1] = amount;
        } else if (sub == answer[0] && amount > answer[1]) {
            answer[1] = amount;
        } 
    }
}