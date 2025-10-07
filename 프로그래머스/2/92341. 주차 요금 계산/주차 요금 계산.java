import java.util.*;

class Solution {
    
    static List<String> carList = new ArrayList<>();
    static Map<String, String> inCar = new HashMap<>(); // 입차한 차들
    static Map<String, Integer> time = new HashMap<>(); // 시간 기록
    static Map<String, Integer> fee = new HashMap<>(); // 요금 기록
    
    public int[] solution(int[] fees, String[] records) {
        
        // 입차 출차 기록
        for (int i=0; i<records.length; i++) {
            String[] split = records[i].split(" ");
            String t = split[0];
            String carNum = split[1];
            String inout = split[2];
            
            if (inout.equals("IN")) { // 입차일 때
                inCar.put(carNum, t);
            } else { // 출차일 때
                String inTime = inCar.get(carNum);
                int d = strToTime(t) - strToTime(inTime);
                time.put(carNum, time.getOrDefault(carNum, 0) + d);
                inCar.remove(carNum);
            }
        }
        
        for (String s : inCar.keySet()) {
            String t = inCar.get(s);
            int d = strToTime("23:59") - strToTime(t);
            time.put(s, time.getOrDefault(s, 0) + d);
        }
        
        int[] answer = new int[time.size()];
        for (String s : time.keySet()) {
            carList.add(s);
            int t = time.get(s);
            
            if (t <= fees[0]) {
                fee.put(s, fees[1]);
            } else {
                int f = (int) Math.ceil((double)(t - fees[0])/fees[2]) * fees[3];
                fee.put(s, fees[1] + f);
            }
        }
        
        Collections.sort(carList);
        for (int i=0; i<carList.size(); i++) {
            answer[i] = fee.get(carList.get(i));
        }
        
        return answer;
    }
    
    private static int strToTime(String s) {
        String[] split = s.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        
        return h * 60 + m;
    }
}