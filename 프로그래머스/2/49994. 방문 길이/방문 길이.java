import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][] board = new boolean[11][11];
        List<String> list = new ArrayList<>();
        
        int x = 5;
        int y = 5;
        
        for (int i=0; i<dirs.length(); i++) {
            Character c = dirs.charAt(i);
            int nx = x;
            int ny = y;
            
            if (c == 'U') {
                nx -= 1;
            } else if (c == 'D') {
                nx += 1;
            } else if (c == 'R') {
                ny += 1;
            } else if (c == 'L') {
                ny -= 1;
            }
            
            if (!isPromising(nx, ny)) continue;
            
            String tmp = intToStr(x, y, nx, ny);
            if (!list.contains(tmp)) {
                answer++;
                list.add(tmp);
                list.add(intToStr(nx, ny, x, y));
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    private static String intToStr(int i1, int i2, int i3, int i4) {
        String tmp = "";
        
        tmp += Integer.toString(i1);
        tmp += Integer.toString(i2);
        tmp += Integer.toString(i3);
        tmp += Integer.toString(i4);
        
        return tmp;
    }
    
    private static boolean isPromising (int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }
}