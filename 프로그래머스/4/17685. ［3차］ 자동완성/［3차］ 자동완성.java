import java.util.*;

class Trie {
    Map<Character, Trie> children = new HashMap<>();
    int count = 0;
}

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Trie root = new Trie();
        
        for (String word : words) {
            Trie trie = root;
            for (char c : word.toCharArray()) {
                trie.children.putIfAbsent(c, new Trie());
                trie = trie.children.get(c);
                trie.count++;
            }
        }
        
        for (String word : words) {
            Trie trie = root;
            int cnt = 0;
            for (char c : word.toCharArray()) {
                cnt++;
                trie = trie.children.get(c);
                if (trie.count == 1) break;
            }
            answer += cnt;
        }
        
        return answer;
    }
}