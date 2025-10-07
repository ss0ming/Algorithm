class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);
            
            // (1) 트리 구조를 위한 길이 보정 (2^n - 1)
            int size = 1;
            while (size < bin.length()) {
                size = size * 2 + 1;
            }
            bin = String.format("%" + size + "s", bin).replace(' ', '0');
            
            // (2) 재귀 검증
            if (check(bin)) {
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    private static boolean check(String s) {
        if (s.length() <= 1) return true;
        int mid = s.length() / 2;
        
        char root = s.charAt(mid);
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);
        
        // 부모가 0인데, 자식 중 하나라도 1이면 불가능
        if (root == '0' && (left.charAt(left.length() / 2) == '1' || right.charAt(right.length() / 2) == '1')) {
            return false;
        }
        
        return check(left) && check(right);
    }
}
