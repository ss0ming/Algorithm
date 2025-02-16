import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> nicknameMap = new HashMap<>();
        List<String[]> messages = new ArrayList<>();
        
        for (int i=0; i<record.length; i++) {
            String[] rec = record[i].split(" ");
            String command = rec[0];
            String id = rec[1];
            String nickname = "";
            
            if (rec.length == 3) {
                nickname = rec[2];
            }
            
            if (command.equals("Enter")) {
                nicknameMap.put(id, nickname);
                messages.add(new String[]{id, command});
            } else if (command.equals("Leave")) {
                messages.add(new String[]{id, command});
            } else if (command.equals("Change")) {
                nicknameMap.put(id, nickname);
            }
        }
        
        String[] answer = new String[messages.size()];
        for (int i=0; i<answer.length; i++) {
            String[] data = messages.get(i);
            
            answer[i] = nicknameMap.get(data[0]);
            
            if (data[1].equals("Enter")) {
                answer[i] += "님이 들어왔습니다.";
            } else if (data[1].equals("Leave")) {
                answer[i] += "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}