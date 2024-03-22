import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
 
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        
        for (int i=0; i<records.length; i++) {
            String[] info = records[i].split(" ");
            
            if (info[2].equals("IN")) {
                
                map.put(info[1], hourToMin(info[0]));
                if (!feeMap.containsKey(info[1])) feeMap.put(info[1], 0);
                
            } else if (info[2].equals("OUT")) {
                
                int t = map.get(info[1]);
                map.remove(info[1]);
                feeMap.replace(info[1], feeMap.get(info[1]) + (hourToMin(info[0]) - t));
                
            }
        }
        
        for (String key : map.keySet()) {
            System.out.println(key + " : " + feeMap.get(key));
            feeMap.replace(key, feeMap.get(key) + hourToMin("23:59") - map.get(key));
        }
        
        int[] answer = new int[feeMap.size()];
        Map<String, Integer> sortedMap = new TreeMap<>(feeMap);
        int idx = 0;
        
        for (String key : sortedMap.keySet()) {
            int fee = 0;
            int time = sortedMap.get(key);
            System.out.println(time);
            
            if (time <= fees[0]) {
                fee = fees[1];
            } else {
                fee += fees[1];
                time -= fees[0];
                fee += ((int) Math.ceil((double) time / fees[2]) * fees[3]);
            }
            
            answer[idx++] = fee;
        }

        return answer;
    }
    
    public static int hourToMin(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        return h * 60 + m;
    }
}