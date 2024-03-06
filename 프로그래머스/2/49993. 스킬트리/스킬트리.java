import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i=0; i<skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            skill_tree = skill_tree.replaceAll("[^" + skill + "]", "");
            
            boolean bool = true;
            
            for (int j=0; j<skill_tree.length(); j++) {
                if (skill.charAt(j) != skill_tree.charAt(j)) {
                    bool = false;
                    break;
                }
            }
            
            if (bool) answer++;
        }
        
        return answer;
    }
}