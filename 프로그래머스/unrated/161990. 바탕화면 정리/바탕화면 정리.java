class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;
        
        for (int i=0; i<wallpaper.length; i++) {
            String s = wallpaper[i];
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(j) == '#') {
                    if (lux > i) lux = i;
                    if (rdx < i) rdx = i;
                    if (luy > j) luy = j;
                    if (rdy < j) rdy = j;
                }
            }
        }
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        
        return answer;
    }
}