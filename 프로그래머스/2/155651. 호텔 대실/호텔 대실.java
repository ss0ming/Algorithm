import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] tmp = new int[book_time.length][2];
        List<Integer> rooms = new ArrayList<>();
        
        for (int i=0; i<book_time.length; i++) {
            tmp[i][0] = hToM(book_time[i][0]);
            tmp[i][1] = hToM(book_time[i][1])+10;
        }
        

        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        for (int[] t : tmp) {

            if (rooms.isEmpty()) {
                rooms.add(t[1]);
                continue;
            }
            boolean needRoom = true;
            for (int r : rooms) {
                if (t[0] >= r) {
                    rooms.remove(Integer.valueOf(r));
                    rooms.add(t[1]);
                    Collections.sort(rooms);
                    needRoom = false;
                    break;
                }
                
            }
            
            if (needRoom) {
                rooms.add(t[1]);
                Collections.sort(rooms);
            }
        }

        return rooms.size();
    }
    
    private static int hToM(String strH) {
        String[] hm = strH.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}