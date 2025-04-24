class Solution {
    public int solution(int[] stones, int k) {
        int l = 0;
        int r = 200_000_000;
        
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(stones, k, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
    
    private static boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        
        for (int i=0; i<stones.length; i++) {
            if (stones[i] - mid <= 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            
            if (cnt == k) {
                return false;
            }
        }
        
        return true;
    }
}