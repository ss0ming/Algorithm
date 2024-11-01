class Solution {
    public int solution(int[][] sizes) {        
        int w = 0;
        int h = 0;
        
        for (int i=0; i<sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                w = Math.max(sizes[i][0], w);
                h = Math.max(sizes[i][1], h);
            } else {
                w = Math.max(sizes[i][1], w);
                h = Math.max(sizes[i][0], h);
            }
        }
        
        return w * h;
    }
}