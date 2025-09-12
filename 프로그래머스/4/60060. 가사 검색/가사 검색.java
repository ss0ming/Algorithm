import java.util.*;

class Solution {
    // 이진탐색으로 [low, high] 범위의 개수 반환
    int countByRange(List<String> arr, String left, String right) {
        return upperBound(arr, right) - lowerBound(arr, left);
    }

    int lowerBound(List<String> arr, String target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid).compareTo(target) >= 0) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    int upperBound(List<String> arr, String target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid).compareTo(target) > 0) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int[] solution(String[] words, String[] queries) {
        // 길이별로 정방향 / 역방향 단어 분리
        Map<Integer, List<String>> dict = new HashMap<>();
        Map<Integer, List<String>> revDict = new HashMap<>();

        for (String w : words) {
            dict.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
            revDict.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(new StringBuilder(w).reverse().toString());
        }

        // 각 리스트를 정렬
        for (List<String> list : dict.values()) Collections.sort(list);
        for (List<String> list : revDict.values()) Collections.sort(list);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int len = q.length();
            if (!dict.containsKey(len)) { // 해당 길이 단어가 없음
                answer[i] = 0;
                continue;
            }

            // 앞에 ? 있는 경우: 문자열 뒤집어서 뒤쪽 비교
            if (q.charAt(0) == '?') {
                String rev = new StringBuilder(q).reverse().toString();
                String left = rev.replace('?', 'a');
                String right = rev.replace('?', 'z');
                answer[i] = countByRange(revDict.get(len), left, right);
            } else { // 뒤에 ? 있는 경우
                String left = q.replace('?', 'a');
                String right = q.replace('?', 'z');
                answer[i] = countByRange(dict.get(len), left, right);
            }
        }
        return answer;
    }
}
