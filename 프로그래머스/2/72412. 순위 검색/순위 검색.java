import java.util.*;

class Solution {
    
    static Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        for (String s : info) {
            String[] arr = s.split(" ");
            String[] keys = {arr[0], arr[1], arr[2], arr[3]};
            int score = Integer.parseInt(arr[4]);
            makeKey(keys, 0, "", score);
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        } 
        
        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] arr = q.split(" ");
            String key = String.join(" ", Arrays.copyOfRange(arr, 0, 4));
            int score = Integer.parseInt(arr[4]);
            
            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                int idx = lowerBound(list, score);
                answer[i] = list.size() - idx;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    private static void makeKey(String[] arr, int depth, String cur, int score) {
        if (depth == 4) {
            map.computeIfAbsent(cur.trim(), k -> new ArrayList<>()).add(score);
            return;
        }
        makeKey(arr, depth + 1, cur + arr[depth] + " ", score);
        makeKey(arr, depth + 1, cur + "- ", score);
    }
    
    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}