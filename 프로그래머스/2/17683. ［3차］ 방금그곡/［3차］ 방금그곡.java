class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceSound(m);
        int len = 0;
        
        for (int i=0; i<musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            int min = calcPlayTime(tmp[0], tmp[1]);
            String sheetMusic = replaceSound(tmp[3]);
            int repeat = min / sheetMusic.length();
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<repeat; j++) {
                sb.append(sheetMusic);
            }
            int mod = min % sheetMusic.length();
            for (int j=0; j<mod; j++) {
                sb.append(sheetMusic.charAt(j));
            }
            
            String music = sb.toString();
            if (music.contains(m)) {
                if (len < min) {
                    len = min;
                    answer = tmp[2];
                }
                
            }
        }
        
        return answer;
    }
    
    private static int calcPlayTime(String h1, String h2) {
        return hourToMin(h2) - hourToMin(h1);
    }
    
    private static int hourToMin(String time) {
        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        return h * 60 + m;
    }
    
    public String replaceSound(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("E#", "e");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");
        s = s.replaceAll("B#", "b");
        
        return s;
    }
}