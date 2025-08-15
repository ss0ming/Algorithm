import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        Arrays.sort(timetable);

        // String 시간 숫자로 바꾸기
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<timetable.length; i++) {
            q.add(strToInt(timetable[i]));
        }
        
        // 셔틀버스 시간대 별로 계산하기
        // 첫 차는 9:00
        int bus = 900;
        int idx = -1;
        for (int i=0; i<n-1; i++) {
            int limit = m;
            
            while (!q.isEmpty() && limit > 0) {
                if (q.peek() <= bus) {
                    q.poll();
                    limit--;
                } else {
                    break;
                }
            }
            bus = addTime(bus, t);
        }
        
        // 막차 이후 삭제하기
        int size = q.size();
        for (int i=0; i<size; i++) {
            int tmp = q.poll();
            if (tmp <= bus) {
                q.add(tmp);
            }
        }

        // 다 탔으면 막차에 맞춰서 나가기
        if (q.size() < m) {
            answer = intToStr(bus);
        } else {
            // 한 자리 남기고 막차에 태우기
            int cur = q.poll();
            for (int i=0; i<m-1; i++) {
                if (q.isEmpty()) {
                    break;
                }
                cur = q.poll();
            }
            if (cur % 100 == 0) {
                int hour = cur / 100 - 1;
                int min = 59;
                answer = intToStr(hour * 100 + min);
            } else {
                answer = intToStr(cur - 1);
            }
        
        }
        
        return answer;
    }
    
    private static int addTime(int time, int t) {
        if (t == 60) {
            return time + 100;
        }
        
        int h = time / 100;
        int m = time % 100 + t;
        if (m > 60) {
            m -= 60;
            h += 1;
            return h * 100 + m;
        }
        
        return time + t;
    }
    
    private static int strToInt(String strTime) {
        String[] splitStr = strTime.split(":");
        int h = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);
        
        return h * 100 + m;
    }
    
    private static String intToStr(int time) {
        String h = Integer.toString(time / 100);
        String m = Integer.toString(time % 100);
        
        if (h.length() == 1) {
            h = "0" + h;
        }
        
        if (m.length() == 1) {
            m = "0" + m;
        }
        
        return h + ":" + m;
    }
}