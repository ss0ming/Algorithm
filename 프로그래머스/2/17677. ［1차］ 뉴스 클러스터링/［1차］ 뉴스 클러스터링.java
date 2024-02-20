import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int hap = 0;
        int cnt = 0;
        
        List<String> list = new LinkedList<>();
            
        for (int i=0; i<str1.length()-1; i++) {
            String str = str1.substring(i, i+2).toLowerCase();
            if (!str.matches("^[a-zA-Z]*$")) continue;
            System.out.println(str);
            list.add(str);
            hap++;
        }
        for (int i=0; i<str2.length()-1; i++) {
            String str = str2.substring(i, i+2).toLowerCase();
            if (!str.matches("^[a-zA-Z]*$")) continue;
            if (list.contains(str)) {
                list.remove(str);
                cnt++;
            } else {
                hap++;
            }
        }
        System.out.println(cnt);
        System.out.println(list.size());
        answer = (int)((double)cnt / hap * 65536);
        if (cnt ==0 && hap ==0) answer = 65536;
        return answer;
    }
}