import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> tmp = new HashMap<>();
        Map<String, Integer> answer = new HashMap<>();
        
        for (int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            
            if (record[2].equals("IN")) {
                tmp.put(record[1], hToM(record[0]));
            } else {
                int cal = hToM(record[0]) - tmp.get(record[1]);
                tmp.remove(record[1]);
                answer.put(record[1], answer.getOrDefault(record[1], 0) + cal);
            }
        }
        
        List<String> keySet = new ArrayList<>(answer.keySet());
        Collections.sort(keySet);
        
        List<Integer> result = new ArrayList<>();
        
        for (String key : keySet) {
            int price = 0;

        }
        
        return result;
    }
    
    private static int hToM(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}