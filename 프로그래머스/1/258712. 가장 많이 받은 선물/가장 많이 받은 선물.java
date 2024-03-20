import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[][] arr = new int[friends.length][friends.length];
        
        for (int i=0; i<gifts.length; i++) {
            String[] strs = gifts[i].split(" ");
            String a = strs[0];
            String b = strs[1];
            arr[map.get(a)][map.get(b)] += 1;     
        }
        
        int[] jisu = new int[friends.length];
        
        for (int i=0; i<arr.length; i++) {
            int giveGift = 0;
            int recieveGift = 0;
            for (int j=0; j<arr.length; j++) {
                giveGift += arr[i][j];
                recieveGift += arr[j][i];
            }
            jisu[i] = giveGift - recieveGift;
        }
        
        int[] nextM = new int[friends.length];
        
        for (int i=0; i<friends.length; i++) {
            for (int j=i+1; j<friends.length; j++) {
                int a = arr[i][j];
                int b = arr[j][i];
                if (a > b) {
                    nextM[i] += 1;
                } else if (b > a) {
                    nextM[j] += 1;
                } else {
                    if (jisu[i] > jisu[j]) nextM[i] += 1;
                    else if (jisu[i] < jisu[j]) nextM[j] += 1;
                }
            }
        }
        
        for (int i=0; i<friends.length; i++) {
            answer = Math.max(answer, nextM[i]);
        }
        
        return answer;
    }
}