import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String dirs) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 2);
        map.put('L', 3);
        
        Set<String> set = new HashSet<>();
        
        int nowX = 0;
        int nowY = 0;
        
        for (int i=0; i<dirs.length(); i++) {
            int nextX = nowX + dx[map.get(dirs.charAt(i))];
            int nextY = nowY + dy[map.get(dirs.charAt(i))];
            
            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) continue;
            
            set.add(move(nowX, nowY, nextX, nextY));
            set.add(move(nextX, nextY, nowX, nowY));
            
            nowX = nextX;
            nowY = nextY;
        }
        
        System.out.println(set.size());
        
        return set.size() / 2;
    }
    
    public static String move(int x, int y, int x2, int y2) {
        String s = Integer.toString(x);
        s += Integer.toString(y);
        s += Integer.toString(x2);
        s += Integer.toString(y2);
        
        return s;
    }
}