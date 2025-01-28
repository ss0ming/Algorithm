class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skill_tree : skill_trees) {
            if (isValid(skill_tree, skill)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValid(String tree, String skill) {
        int skillIdx = 0;
        
        for (char c : tree.toCharArray()) {
            if (skill.contains(String.valueOf(c))) {
                if (skill.charAt(skillIdx) == c) {
                    skillIdx++;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}