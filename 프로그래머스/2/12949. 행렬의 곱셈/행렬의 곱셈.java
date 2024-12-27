class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2[0].length; j++) {
                answer[i][j] = calc(i, j, arr1, arr2);
            }
        }
        return answer;
    }
    
    private static int calc(int x, int y, int[][] arr1, int[][] arr2) {
        int sum = 0;
        
        for (int i=0; i< arr2.length; i++) {
            sum += (arr1[x][i] * arr2[i][y]);
        }
        
        return sum;
    }
}