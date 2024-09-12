import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> idx = new HashMap<>();
        int[][] table = new int[friends.length][3];
        int[][] record = new int[friends.length][friends.length];
        
        for (int i=0; i<friends.length; i++) {
            idx.put(friends[i], i);
        }
        
        for (int i=0; i<gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int giveF = idx.get(gift[0]);
            int receiveF = idx.get(gift[1]);
            
            table[giveF][0] += 1;
            table[receiveF][1] += 1;
            record[giveF][receiveF] += 1;
        }
        
        for (int i=0; i<friends.length; i++) {
            table[i][2] = table[i][0] - table[i][1];
            System.out.println(table[i][0] + ":" + table[i][1] + ":" + table[i][2]);
        }
        
        for (int i=0; i<friends.length; i++) {
            int cnt = 0;
            for (int j=0; j<friends.length; j++) {
                if (i == j) continue;
                
                if (record[i][j] > record[j][i]) {
                    System.out.println("one: " + i + " " + j);
                    cnt++;
                } else if (record[i][j] == record[j][i] && table[i][2] > table[j][2]) {
                    System.out.println("two: " + i + " " + j);
                    cnt++;
                }
            }
            System.out.println(cnt);
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}