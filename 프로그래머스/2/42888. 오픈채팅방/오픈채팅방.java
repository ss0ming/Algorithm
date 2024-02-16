import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        String[] answer = {};
        
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            
            if(arr[0].equals("Enter") || arr[0].equals("Leave")){
                list.add(record[i]);
            }
            
            if(arr.length > 2){
                map.put(arr[1], arr[2]);
            }
        }
        
        answer = new String[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            String[] arr = list.get(i).split(" ");    
            answer[i] = "" + map.get(arr[1]);
            
            if(arr[0].equals("Enter")){
                answer[i] += "님이 들어왔습니다.";
            }else if(arr[0].equals("Leave")){
                answer[i] += "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}