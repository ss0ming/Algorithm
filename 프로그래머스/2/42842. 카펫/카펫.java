class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int h = 0;
        
        while (h <= yellow) {
            h++;
            
            if (yellow % h != 0) {
                continue;
            }
            
            int w = yellow / h;
            if ((w+h) * 2 == (brown - 4)) {
                answer[0] = w+2;
                answer[1] = h+2;
                break;
            }
        }
        
        return answer;
    }
}