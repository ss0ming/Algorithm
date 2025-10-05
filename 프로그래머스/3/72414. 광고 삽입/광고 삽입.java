class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "00:00:00";
        if (play_time.equals(adv_time)) return answer;
        
        int playTime = strToSec(play_time);
        int advTime = strToSec(adv_time);
        
        long[] timeLine = new long[playTime+1];
        
        for (int i=0; i<logs.length; i++) {
            String[] split = logs[i].split("-");
            int start = strToSec(split[0]);
            int end = strToSec(split[1]);
            
            timeLine[start] += 1;
            timeLine[end] -= 1;
        }
        
        for (int i=1; i<playTime; i++) {
            timeLine[i] += timeLine[i-1];
        }
        
        for (int i=1; i<playTime; i++) {
            timeLine[i] += timeLine[i-1];
        }
        
        long max = timeLine[advTime];
        int startTime = 0;
        
        for (int i=1; i<playTime+1-advTime; i++) {
            long cur = timeLine[i+advTime-1] - timeLine[i-1];
            if (cur > max) {
                max = cur;
                startTime = i;
            }
        }
        
        int h = startTime / 3600;
        startTime %= 3600;
        int m = startTime / 60;
        startTime %= 60;
        int s = startTime % 60;
        
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
    private static int strToSec(String str) {
        String[] split = str.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int s = Integer.parseInt(split[2]);
        return 3600 * h + m * 60 + s;
    }
}