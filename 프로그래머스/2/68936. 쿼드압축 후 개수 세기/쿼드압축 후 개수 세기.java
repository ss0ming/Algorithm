class Solution {
    
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quadZip(arr, 0, 0, arr.length);

        return answer;
    }
    
    private void quadZip(int[][] arr, int x, int y, int len) {
        if (check(arr, x, y, len)) {
            if (arr[x][y] == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        
        quadZip(arr, x, y, len/2);
        quadZip(arr, x+len/2, y, len/2);
        quadZip(arr, x, y+len/2, len/2);
        quadZip(arr, x+len/2, y+len/2, len/2);
    }
    
    private boolean check(int[][] arr, int x, int y, int len) {
        int target = arr[x][y];
        for (int i=x; i<x+len; i++) {
            for (int j=y; j<y+len; j++) {
                if (arr[i][j] != target) return false;
            }
        }
        
        return true;
    }
}