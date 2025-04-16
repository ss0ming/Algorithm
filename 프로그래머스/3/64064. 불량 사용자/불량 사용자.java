import java.util.*;

class Solution {
    
    static List<List<String>> banned_user;
    static Set<String> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        banned_user = new ArrayList<>();
        
        for (int i=0; i<banned_id.length; i++) {
            List<String> subList = new ArrayList<>();
            for (int j=0; j<user_id.length; j++) {
                if (user_id[j].length() != banned_id[i].length()) {
                    continue;
                }
                
                if (validBannedId(user_id[j], banned_id[i])) {
                    System.out.println(user_id[j]);
                    subList.add(user_id[j]);
                }
            }
            banned_user.add(subList);
        }
        
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < banned_user.size(); i++) {
    List<String> candidates = banned_user.get(i);
    System.out.println("banned_user[" + i + "] = " + candidates);
}
        dfs(0, visited);
        
        return answer.size();
    }
    
    private void dfs(int idx, Set<String> visited) {
        if (visited.size() == banned_user.size()) {
            List<String> tmp = new ArrayList<>(visited);
            Collections.sort(tmp);
            
            String result = String.join(",", tmp);
            answer.add(result);
            return;
        }
        
        for (int i=0; i<banned_user.get(idx).size(); i++) {
            if (!visited.contains(banned_user.get(idx).get(i))) {
                visited.add(banned_user.get(idx).get(i));
                dfs(idx+1, visited);
                visited.remove(banned_user.get(idx).get(i));
            } 
        }
        
        return;
    }
    
    private boolean validBannedId(String id, String target) {
        for (int i=0; i<target.length(); i++) {
            char char_id = id.charAt(i);
            char target_id = target.charAt(i);
            
            if (target_id != '*' && char_id != target_id) {
                return false;
            } 
            
        }
        
        return true;
    }
}