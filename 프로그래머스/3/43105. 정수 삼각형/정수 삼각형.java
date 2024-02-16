class Solution {
    public int solution(int[][] triangle) {
        int[][] arr = new int[triangle.length][triangle.length];
        for (int i=0; i<triangle[triangle.length-1].length; i++) {
            arr[triangle.length-1][i] = triangle[triangle.length-1][i];
        }
        for (int i=triangle.length-2; i>=0; i--) {
            for (int j=0; j<i+1; j++) {
                arr[i][j] = triangle[i][j] + Math.max(arr[i+1][j], arr[i+1][j+1]);
            }
        }
        return arr[0][0];
    }
}