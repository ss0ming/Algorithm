import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);

        // 1. 대문자 -> 소문자
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isUpperCase(c)) sb.setCharAt(i, Character.toLowerCase(c));
        }

        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '-' || c == '_' || c == '.' || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) continue;
            sb.deleteCharAt(i);
        }

        // 3. .. → .
        sb = new StringBuilder(sb.toString().replaceAll("[.]{2,}", "."));

        // 4. 마침표(.)가 맨 앞이거나 맨 뒤에 있다면 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.setLength(sb.length() - 1);

        // 5. 빈 문자열이라면 "a" 삽입
        if (sb.length() == 0) sb.append('a');

        // 6. 길이가 16 이상이면 16번째부터 끝까지 제거
        if (sb.length() > 15) sb.setLength(15);

        // 6-1. 마침표(.)가 맨 뒤에 있다면 제거
        while (sb.charAt(sb.length() - 1) == '.') sb.setLength(sb.length() - 1);

        // 7. 길이가 2 이하라면 마지막 문자를 길이가 3이 될 때까지 삽입
        while (sb.length() < 3) sb.append(sb.charAt(sb.length() - 1));

        return sb.toString();
    }
}